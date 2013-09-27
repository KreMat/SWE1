package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;

public interface Pluggable {

	public Response request(Request r);

}
