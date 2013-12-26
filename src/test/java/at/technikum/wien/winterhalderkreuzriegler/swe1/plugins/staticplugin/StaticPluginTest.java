/**
 * 
 */
package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.staticplugin;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.helper.TestHelper;

/**
 * @author Matthias
 * 
 */
public class StaticPluginTest {

	private TestHelper helper;

	private StaticPlugin staticPlugin;

	@Before
	public void setUp() {
		staticPlugin = new StaticPlugin();
		helper = new TestHelper();
	}

	@Test
	public void testRequest() throws IOException {
		Uri uri = helper.createDefaultUri();
		uri.setPath("/static/index.html");
		Request request = helper.createDefaultRequest();
		Response response = staticPlugin.request(uri, request);
		Assert.assertNotNull(response);
		Assert.assertEquals(StatusCode.STATUS_200, response.getStatusCode());
		Assert.assertEquals("text/html", response.getContentType());
	}
}
