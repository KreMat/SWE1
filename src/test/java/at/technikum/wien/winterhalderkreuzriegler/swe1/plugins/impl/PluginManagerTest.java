/**
 * 
 */
package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.impl;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Method;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.Protocol;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.helper.TestHelper;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.PluginManager;

/**
 * 
 * Testklasse für {@link PluginManager}
 * 
 * @author Matthias
 * 
 */
public class PluginManagerTest {

	private PluginManager pluginManager;

	private TestHelper helper;

	@Before
	public void setUp() {
		pluginManager = new PluginManagerImpl();
		helper = new TestHelper();
	}

	@Test
	public void testExecuteRequest() {
		Uri uri = helper.createUri("localhost", "test/index.html", 8088,
				Protocol.HTTP);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Language", "de");
		Request request = helper.createRequest(null, 0, "text/html", headers,
				Method.GET);
		Response response = pluginManager.excecuteRequest(uri, request);
		Assert.assertNotNull(response);
		Assert.assertEquals(StatusCode.STATUS_200, response.getStatusCode());
	}
}
