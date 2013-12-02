package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SensorDao {

	// private static final String URL =
	// "jdbc:oracle:thin:temperatureplugin@//localhost:1521/xe";
	private static final String URL = "jdbc:mysql://localhost/temperatureplugin";

	private static final String USER = "tempplugin";
	private static final String PASSWD = "123456";

	private Connection getConnection() {
		try {
			// Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");

			return DriverManager.getConnection(URL, USER, PASSWD);

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}

	public void createSensorData(SensorData data) {
		try {

			Connection con = getConnection();

			PreparedStatement stmt = con
					.prepareStatement("insert into sensorData (value, time) values (?, ?);");

			stmt.setDouble(1, data.getValue());
			stmt.setTimestamp(2, data.getTimestamp());

			stmt.execute();

			stmt.close();
			con.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
}
