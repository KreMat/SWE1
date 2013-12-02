package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SensorData {

	private double value;

	private Timestamp timestamp;

	public double getValue() {
		return value;
	}

	@XmlElement
	public void setValue(double value) {
		this.value = value;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	@XmlElement
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
