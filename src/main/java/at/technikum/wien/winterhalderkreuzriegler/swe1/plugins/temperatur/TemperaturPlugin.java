package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.ResponseBuilder;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.enums.StatusCode;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable;

public class TemperaturPlugin implements Pluggable {

	private SensorReader reader;
	private SensorDao sensorDao;

	@Override
	public Response request(Uri uri, Request request) {
		Response response = ResponseBuilder
				.buildResponse(StatusCode.STATUS_500);
		// TODO implement me
		return response;
	}

	private String marshalSensorData(SensorData data) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SensorData.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			StringWriter writer = new StringWriter();

			jaxbMarshaller.marshal(data, writer);
			return writer.toString();
		} catch (JAXBException e) {
			throw new IllegalStateException(e);
		}
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
					System.out.println(marshalSensorData(data));
				}

				private double readValue() {
					return Math.random();
				}

			}, 0, 5000);
			// Alle 5 Sekunden ausführen
		}

	}

}
