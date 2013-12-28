package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.util.Calendar;

public class TemperaturHelper {

	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static int getMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	public static int getDay() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

}
