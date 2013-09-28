package at.technikum.wien.winterhalderkreuzriegler.swe1.helper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Method;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Protocol;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.HTTPRequest;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.UriImpl;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

public class TestHelper {

	public Uri createDefaultUri() {
		return createUri("localhost", "test/index.html", 8088, Protocol.HTTP);
	}

	public Uri createUri(String host, String path, int port, Protocol protocol) {
		Uri uri = new UriImpl();
		uri.setHost(host);
		uri.setPath(path);
		uri.setPort(port);
		uri.setProtocol(protocol);
		return uri;
	}

	public Request createDefaultRequest() {
		Map<String, String> headers = new HashMap<String, String>();
		return createRequest(null, 0, "text/html", headers, Method.GET);
	}

	public Request createRequest(InputStream body, int length, String type,
			Map<String, String> headers, Method method) {
		Request r = new HTTPRequest();
		r.setBody(body);
		r.setContentLength(length);
		r.setContentType(type);
		r.setHeaders(headers);
		r.setMethod(method);
		return r;
	}

}
