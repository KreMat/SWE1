package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Protocol;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Version;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

public class UriImpl implements Uri {

	private int port;
	private Protocol protocol;
	private Version version;
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
	public Protocol getProtocol() {
		return protocol;
	}

	@Override
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	@Override
	public Version getVersion() {
		return version;
	}

	@Override
	public void setVersion(Version version) {
		this.version = version;
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

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("URI: \n");
		out.append("port: " + port);
		out.append("\n");
		out.append("protocol: " + protocol);
		out.append("\n");
		out.append("version: " + version);
		out.append("\n");
		out.append("host: " + host);
		out.append("\n");
		out.append("path: " + path);
		out.append("\n");

		return out.toString();
	}

}