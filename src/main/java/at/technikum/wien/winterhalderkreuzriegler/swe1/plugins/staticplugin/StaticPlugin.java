/**
 * 
 */
package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.staticplugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.WebserverConstants;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.Cache;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable;

/**
 * 
 * Implementierung zum Interface {@link Pluggable}
 * 
 * Diese Plugin liefert statisch Files aus dem Filesystem des Servers an den
 * Aufrufer zurück
 * 
 * @author Matthias
 * 
 */
public class StaticPlugin implements Pluggable {

	@Override
	public Response request(Uri uri, Request request) {
		String filePath = uri.getPath().substring(1)
				.substring(uri.getPath().substring(1).indexOf('/'));
		File fileToRead = new File(
				Cache.properties.getProperty(WebserverConstants.WWW_HOME_KEY)
						+ filePath);

		InputStream repsponseBody;
		String contentType;
		long contentLength = 0;
		try {
			repsponseBody = new FileInputStream(fileToRead);
			contentType = Files.probeContentType(Paths.get(Cache.properties
					.getProperty(WebserverConstants.WWW_HOME_KEY) + filePath));
			contentLength = Files.size(fileToRead.toPath());
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
