package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain;

import java.io.InputStream;
import java.util.Map;

public interface Request {
	public Map<String, String> getHeaders();
	
	public String getContentType();
	
	public int getContentLength();
	
	public Uri getUrl();
	
	public InputStream getBody();
}
