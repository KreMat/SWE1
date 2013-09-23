package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.Uri;

public interface PluginManager {
	
	public Response excecuteRequest(Uri uri, Request request);

}
