package at.technikum.wien.winterhalderkreuzriegler.swe1.webserver.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Method;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Protocol;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Version;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.HTTPRequest;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.UriImpl;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.impl.PluginManagerImpl;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.PluginManager;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		final ExecutorService pool;
		final ServerSocket serverSocket;
		int port = 8088;
		String var = "C";
		String zusatz;
		if (args.length > 0)
			var = args[0].toUpperCase();
		if (var == "C") {
			// Liefert einen Thread-Pool, dem bei Bedarf neue Threads
			// hinzugefügt
			// werden. Vorrangig werden jedoch vorhandene freie Threads benutzt.
			pool = Executors.newCachedThreadPool();
			zusatz = "CachedThreadPool";
		} else {
			int poolSize = 10;
			// Liefert einen Thread-Pool für maximal poolSize Threads
			pool = Executors.newFixedThreadPool(poolSize);
			zusatz = "poolsize=" + poolSize;
		}
		serverSocket = new ServerSocket(port);
		// Thread zur Behandlung der Client-Server-Kommunikation, der Thread-
		// Parameter liefert das Runnable-Interface (also die run-Methode für
		// t1).
		Thread t1 = new Thread(new NetworkService(pool, serverSocket));
		System.out.println("Start NetworkService(Multiplikation), " + zusatz
				+ ", Thread: " + Thread.currentThread());
		// Start der run-Methode von NetworkService: warten auf Client-request
		t1.start();
		//
		// reagiert auf Strg+C, der Thread(Parameter) darf nicht gestartet sein
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				System.out.println("Strg+C, pool.shutdown");
				pool.shutdown(); // keine Annahme von neuen Anforderungen
				try {
					// warte maximal 4 Sekunden auf Beendigung aller
					// Anforderungen
					pool.awaitTermination(4L, TimeUnit.SECONDS);
					if (!serverSocket.isClosed()) {
						System.out.println("ServerSocket close");
						serverSocket.close();
					}
				} catch (IOException e) {
				} catch (InterruptedException ei) {
				}
			}
		});
	}
}

// Thread bzw. Runnable zur Entgegennahme der Client-Anforderungen
class NetworkService implements Runnable { // oder extends Thread
	private final ServerSocket serverSocket;
	private final ExecutorService pool;

	public NetworkService(ExecutorService pool, ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		this.pool = pool;
	}

	public void run() { // run the service
		try {
			// Endlos-Schleife: warte auf Client-Anforderungen
			// Abbruch durch Strg+C oder Client-Anforderung 'Exit',
			// dadurch wird der ServerSocket beendet, was hier zu einer
			// IOException
			// führt und damit zum Ende der run-Methode mit vorheriger
			// Abarbeitung der
			// finally-Klausel.
			while (true) {
				/*
				 * Zunächst wird eine Client-Anforderung
				 * entgegengenommen(accept-Methode). Der ExecutorService pool
				 * liefert einen Thread, dessen run-Methode durch die
				 * run-Methode der Handler-Instanz realisiert wird. Dem Handler
				 * werden als Parameter übergeben: der ServerSocket und der
				 * Socket des anfordernden Clients.
				 */
				Socket cs = serverSocket.accept(); // warten auf
													// Client-Anforderung

				// starte den Handler-Thread zur Realisierung der
				// Client-Anforderung
				pool.execute(new Handler(cs));
			}
		} catch (IOException ex) {
			System.out.println("--- Interrupt NetworkService-run");
		} finally {
			System.out.println("--- Ende NetworkService(pool.shutdown)");
			pool.shutdown(); // keine Annahme von neuen Anforderungen
			try {
				// warte maximal 1 Sekunden auf Beendigung aller Anforderungen
				pool.awaitTermination(1L, TimeUnit.SECONDS);
				if (!serverSocket.isClosed()) {
					System.out
							.println("--- Ende NetworkService:ServerSocket close");
					serverSocket.close();
				}
			} catch (IOException e) {
			} catch (InterruptedException ei) {
			}
		}
	}
}

// Thread bzw. Runnable zur Realisierung der Client-Anforderungen
class Handler implements Runnable { // oder 'extends Thread'
	private final Socket client;

	Handler(Socket client) { // Server/Client-Socket
		this.client = client;
	}

	public void run() {

		try {

			System.out.println("running service, " + Thread.currentThread());

			PrintWriter out = new PrintWriter(client.getOutputStream(), true);

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(client.getInputStream()));

			Request request = new HTTPRequest();
			Uri uri = new UriImpl();

			int lineNumber = 1;
			String line;
			while ((line = bufferedReader.readLine()) != null) {

				if (line.length() == 0) {
					// zwischen Header und Body oder End of Header
					request.setBody(client.getInputStream());
					break;
				} else {

					if (lineNumber == 1) {
						// parse first Line
						String[] requestLine = line.split(" ");

						request.setMethod(Method.valueOf(requestLine[0].trim()));

						uri.setPath(requestLine[1].trim());
						String[] splittetProtocol = requestLine[2].trim()
								.split("\\/");

						Protocol p = Protocol.valueOf(splittetProtocol[0]);
						uri.setProtocol(p);

						Version v = Version
								.getByVersionString(splittetProtocol[1]);
						uri.setVersion(v);

					} else {
						String[] headerArgs = line.split(": ", 2);
						// headers Map befuellen
						request.addToHeader(headerArgs[0], headerArgs[1]);

						if (headerArgs[0].equals("Content-Length")) {
							request.setContentLength(Integer
									.parseInt(headerArgs[1]));
						}

						if (headerArgs[0].equals("Content-Type")) {
							request.setContentType(headerArgs[1]);
						}

						if (headerArgs[0].equals("Host")) {
							String[] splittedHost = headerArgs[1].split(":");
							uri.setHost(splittedHost[0]);
							uri.setPort(Integer.parseInt(splittedHost[1]));
						}
					}
				}
				lineNumber++;
			}

			PluginManager manager = new PluginManagerImpl();
			Response response = manager.excecuteRequest(uri, request);

			out.println(uri.getProtocol().name() + "/"
					+ uri.getVersion().getVersion() + " "
					+ response.getStatusCode().getCode() + " OK");
			out.println("Content-Type: " + response.getContentType());
			out.println("Content-Length: " + response.getContentLength());
			for (Entry<String, String> entry : response.getHeaders().entrySet()) {
				out.println(entry.getKey() + ": " + entry.getValue());
			}

			out.println();

			if(response.getBody() != null){
				
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getBody()));

			String outline;
			while ((outline = reader.readLine()) != null) {
				out.println(outline);
			}
			}
		} catch (IOException e) {
			System.out.println("IOException, Handler-run");
		} finally {
			// out.println(response); // Rückgabe Ergebnis an den Client
			if (!client.isClosed()) {
				System.out.println("****** Handler:Client close");
				try {
					client.close();
				} catch (IOException e) {
				}
			}
		}
	} // Ende run
}
