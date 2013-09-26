package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

public class UriImpl implements Uri {
	
	private int port;
	private String protocol;
	private String host;
	private String path;
	

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String getProtocol() {
		return protocol;
	}

	@Override
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

}
