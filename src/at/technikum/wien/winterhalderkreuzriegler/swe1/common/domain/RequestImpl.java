package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain;

import java.io.InputStream;
import java.util.Map;

public class RequestImpl implements Request {
	
	private Map<String, String> headers;
	private String contentType;
	private int contentLength;
	private Uri uri;
	private InputStream body;

	@Override
	public Map<String, String> getHeaders() {
		return headers;
	}

	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public int getContentLength() {
		return contentLength;
	}

	@Override
	public Uri getUri() {
		return uri;
	}

	@Override
	public InputStream getBody() {
		return body;
	}
	
	public void parseLine(String line, int lineNumber){
		if(line == ""){
			// zwischen Header und Body oder End of Header
		}else{
			String[] headerArgs = line.split(" ",2);

			if(lineNumber == 1){
				// parse first Line
				if(headerArgs[0] == "GET"){
					//header Method schreiben wo? im request? under uri?
				}
				System.out.println(headerArgs[0]);
				System.out.println(headerArgs.length);
				
			}else{
				System.out.println(headerArgs[0]);
				System.out.println(headerArgs.length);
				System.out.println(line);
			}
			
		}
	}
	
	public String toString(){
		StringBuilder out = new StringBuilder();
		
		return out.toString();
	}

}
