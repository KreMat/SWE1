package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain;

public interface Uri {
	public int getPort();
	
	public void setPort(int port);
	
	public String getProtocol();
	
	public void setProtocol(String protocol);
	
	public String getHost();
	
	public void setHost(String host);
	
	public String getPath();
	
	public void setPath(String path);
	
}
