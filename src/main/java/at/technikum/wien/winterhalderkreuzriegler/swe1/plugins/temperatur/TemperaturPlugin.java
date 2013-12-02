package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

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

	private String marshalSensorData(SensorWrapper wrapper) {
		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(SensorWrapper.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// für eine schöne Formatierung ;-)
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			StringWriter writer = new StringWriter();

			jaxbMarshaller.marshal(wrapper, writer);
			return writer.toString();
		} catch (JAXBException e) {
			throw new IllegalStateException(e);
		}
	}

	@XmlRootElement
	private static class SensorWrapper {

		private List<SensorData> list = new ArrayList<SensorData>();

		@XmlElement(name = "data")
		public List<SensorData> getList() {
			return list;
		}

		public void add(SensorData data) {
			list.add(data);
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
					SensorWrapper wrapper = new SensorWrapper();
					wrapper.add(data);
					wrapper.add(data);
					System.out.println(marshalSensorData(wrapper));
				}

				private double readValue() {
					return Math.random();
				}

			}, 0, 5000);
			// Alle 5 Sekunden ausführen
		}

	}

}
