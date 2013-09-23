package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain;

import java.io.OutputStream;
import java.util.Map;

public interface Response {

	public StatusCode getStatusCode();

	public void setStatusCode(StatusCode code);

	public int getContentLength();

	public void setContentLength(int length);

	public String getContentType();

	public void setContentType(String type);

	public OutputStream getBody();

	public void setBody(OutputStream o);
	
	public Map<String, String> getHeaders();
	
	public void setHeaders(Map<String,String> headers);

}
