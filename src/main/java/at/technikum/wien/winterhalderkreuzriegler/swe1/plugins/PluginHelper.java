package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;

public class PluginHelper {

	public static Response createFileResponse(String filePath) {
		File file = new File(filePath);
		InputStream repsponseBody;
		String contentType;
		long contentLength = 0;
		try {
			repsponseBody = new FileInputStream(file);
			contentType = Files.probeContentType(Paths.get(filePath));
			contentLength = Files.size(file.toPath());
		} catch (IOException e) {
			Response fault = ResponseBuilder
					.buildResponse(StatusCode.STATUS_404);
			return fault;
		}
		Response response = ResponseBuilder
				.buildResponse(StatusCode.STATUS_200);
		response.setBody(repsponseBody);
		response.setContentType(contentType);
		response.setContentLength(contentLength);
		response.setHeaders(new HashMap<String, String>());
		return response;
	}
}
