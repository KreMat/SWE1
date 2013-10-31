package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Request;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Response;
import at.technikum.wien.winterhalderkreuzriegler.swe1.common.domain.interfaces.Uri;
import at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.interfaces.Pluggable;

public class TemperaturPlugin implements Pluggable {

	@Override
	public Response request(Uri uri, Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start() {
		// TODO Hier wird der Thread gestartet, in dem die Serverdaten
		// ausgelesen
		// werden
		System.out.println("TemperaturPlugin gestartet");
	}

	@Override
	public void stop() {
		// TODO Hier wird der Thread, der die Serverdaten ausliest beendet
		System.out.println("TemperaturPlugin beendet");
	}

}
