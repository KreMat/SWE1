package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import org.junit.Test;

public class TestTemperaturePlugin {

	@Test
	public void testStart() {
		TemperaturPlugin plugin = new TemperaturPlugin();
		plugin.start();
	}

}
