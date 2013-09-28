package at.technikum.wien.winterhalderkreuzriegler.swe1.testplugins;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable;

public class TestPlugin implements Pluggable {

	@Override
	public Response request(Request r) {
		System.out.println(TestPlugin.class.getSimpleName()
				+ " wurde ausgeführt!");
		return ResponseBuilder.buildResponse(StatusCode.STATUS_200);
	}

}
