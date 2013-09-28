package at.technikum.wien.winterhalderkreuzriegler.swe1.common;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.HTTPResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;

public class ResponseBuilder {

	public static Response buildResponse(StatusCode status) {
		// TODO MK - implement me
		Response r = new HTTPResponse();
		r.setStatusCode(status);
		return r;
	}

}
