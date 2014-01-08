package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class TestTemperaturePlugin {

	@Before
	public void setUp(){
	}
	
	@Test
	public void testStart() {
		TemperaturPlugin plugin = new TemperaturPlugin();
		plugin.start();
	}
	
	@Test
	public void insertData(){
		
		Calendar toDay = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) -10);
		
		SensorDao dao = new SensorDao();
		
		while(cal.getTimeInMillis() < toDay.getTimeInMillis()){
			for(int i = 0; i < 10; i++){
				SensorData data = new SensorData();
				data.setTime(cal.getTimeInMillis()+(8640000*i));
				data.setValue(Math.random());
				dao.createSensorData(data);
				
			}
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1);
		}
	}

}
