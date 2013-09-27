package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins;

import junit.framework.Assert;

import org.junit.Test;

public class PluginCacheTest {

	@Test
	public void testRefreshPlugins() {
		Assert.assertEquals(2, PluginCache.plugins.size());
		PluginCache.plugins.get("test").request(null);
		PluginCache.plugins.get("test2").request(null);
	}

}
