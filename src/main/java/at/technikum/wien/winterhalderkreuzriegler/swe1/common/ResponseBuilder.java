package at.technikum.wien.winterhalderkreuzriegler.swe1.common;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.impl.HTTPResponse;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;

public class ResponseBuilder {

	public static Response buildResponse(StatusCode status404, Uri uri) {
		// TODO MK - implement me
		return new HTTPResponse();
	}

}
