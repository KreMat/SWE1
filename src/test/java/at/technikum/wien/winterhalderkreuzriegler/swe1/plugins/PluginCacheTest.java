package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins;

import junit.framework.Assert;

import org.junit.Test;

public class PluginCacheTest {

	@Test
	public void testRefreshPlugins() {
		Assert.assertEquals(3, Cache.plugins.size());
		Cache.plugins.get("test").request(null, null);
	}

}
