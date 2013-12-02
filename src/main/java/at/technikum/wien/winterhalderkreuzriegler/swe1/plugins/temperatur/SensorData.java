package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class SensorData {

	private double value;

	private Timestamp timestamp;

	private long id;

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

	public long getId() {
		return id;
	}

	@XmlAttribute
	public void setId(long id) {
		this.id = id;
	}

}
