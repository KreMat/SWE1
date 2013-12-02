package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable;

public class TemperaturPlugin implements Pluggable {

	private SensorReader reader;
	private SensorDao sensorDao;

	@Override
	public Response request(Uri uri, Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start() {
		sensorDao = new SensorDao();
		reader = new SensorReader();
		reader.run();
	}

	@Override
	public void stop() {
		// Eventuell sollte man hier den Thread stoppen
	}

	private class SensorReader implements Runnable {

		@Override
		public void run() {
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					SensorData data = new SensorData();
					data.setValue(readValue());
					data.setTimestamp(new Timestamp(System.currentTimeMillis()));
					sensorDao.createSensorData(data);
				}

				private double readValue() {
					return Math.random();
				}

			}, 0, 5000);
			// Alle 5 Sekunden ausführen
		}

	}

}
