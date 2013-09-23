package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.Response;

public interface Pluggable {

	public void start();

	public void stop();
	
	public Response request(Request r);

}
