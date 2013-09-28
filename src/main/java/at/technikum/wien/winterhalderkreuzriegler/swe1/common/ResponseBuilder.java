package at.technikum.wien.winterhalderkreuzriegler.swe1.common;

import java.util.HashMap;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.HTTPResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;

public class ResponseBuilder {

	public static Response buildResponse(StatusCode status) {
		Response r = new HTTPResponse();
		r.setHeaders(new HashMap<String, String>());
		r.setStatusCode(status);
		return r;
	}

}
