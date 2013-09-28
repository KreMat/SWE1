/**
 * 
 */
package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.impl;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.PluginCache;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.PluginManager;

/**
 * Implementierung des Interface {@link PluginManager}
 * 
 * @author Matthias
 * 
 */
public class PluginManagerImpl implements PluginManager {

	@Override
	public Response excecuteRequest(Uri uri, Request request) {
		String pluginKey = uri.getPath().split("\\/")[0];
		if (pluginKey != null && PluginCache.plugins.containsKey(pluginKey)) {
			return PluginCache.plugins.get(pluginKey).request(request);
		}
		return ResponseBuilder.buildResponse(StatusCode.STATUS_404);
	}
}
