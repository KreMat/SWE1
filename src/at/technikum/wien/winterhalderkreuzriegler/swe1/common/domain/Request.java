package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain;

import java.io.InputStream;
import java.util.Map;

public interface Request {
	public String getMethod();
	
	public void setMethod(String method);
	
	public Map<String,String> getHeaders();
	
	public void setHeaders(Map<String,String> headers);
	
	public String getContentType();
	
	public void setContentType(String type);
	
	public int getContentLength();
	
	public void setContentLength(int length);
	
	public Uri getUri();
	
	public void setUri(Uri uri);
	
	public InputStream getBody();
	
	public void setBody(InputStream body);
	
	public void addToHeader(String key, String value);
}
