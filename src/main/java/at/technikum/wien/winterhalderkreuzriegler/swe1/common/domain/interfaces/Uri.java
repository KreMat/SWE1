package at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces;

import java.util.Map;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Protocol;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Version;

public interface Uri {

	/**
	 * getter für den Port
	 * 
	 * @return port - z.B.: 8088
	 */
	public int getPort();

	/**
	 * Setter für den Port
	 * 
	 * @param port
	 *            port - z.B.: 8088
	 */
	public void setPort(int port);

	/**
	 * Getter für die ProtocolVersion {@link Version}
	 * 
	 * @return version - z.B.: {@link Version#V1_1}
	 */
	public Version getVersion();

	/**
	 * Setter für die ProtocolVersion {@link Version}
	 * 
	 * @param version
	 *            version - z.B.: {@link Version#V1_1}
	 */
	public void setVersion(Version version);

	/**
	 * Getter für das {@link Protocol}
	 * 
	 * @return protocol - z.B.: {@link Protocol#HTTP}
	 */
	public Protocol getProtocol();

	/**
	 * Setter für das {@link Protocol}
	 * 
	 * @param protocol
	 *            protocol - z.B.: {@link Protocol#HTTP}
	 */
	public void setProtocol(Protocol protocol);

	/**
	 * Getter für den Host
	 * 
	 * @return host - z.B.: localhost
	 */
	public String getHost();

	/**
	 * Setter für den Host
	 * 
	 * @param host
	 *            host - z.B.: 127.0.0.1
	 */
	public void setHost(String host);

	/**
	 * Getter für den Path
	 * 
	 * @return path - z.B.: GetTemperature/2012/09/20
	 */
	public String getPath();

	/**
	 * Setter für den Path
	 * 
	 * @param path
	 *            path - z.B.: static/index.html
	 */
	public void setPath(String path);

	/**
	 * Getter für die GET-Parameter
	 * 
	 * @return params - z.B.: street=MyStreet
	 */
	public Map<String, String> getGETParams();

	/**
	 * Getter für die Parameter
	 * 
	 * @param params
	 *            params - z.B.: street=MyStreet
	 */
	public void setGETParams(Map<String, String> params);

}
