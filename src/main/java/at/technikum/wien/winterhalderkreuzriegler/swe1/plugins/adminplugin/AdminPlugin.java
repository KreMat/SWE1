/**
 * 
 */
package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.adminplugin;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.helper.UriHelper;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.PluginHelper;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable;

/**
 * @author Matthias
 * 
 */
public class AdminPlugin implements Pluggable {

	@Override
	public Response request(Uri uri, Request request) {
		String path = UriHelper.convertPath(uri.getPath());
		if ("".equals(path) || "index.html".equals(path)) {
			return PluginHelper.createFileResponse("index.html");
		}
		return ResponseBuilder.buildResponse(StatusCode.STATUS_404);
	}

}
