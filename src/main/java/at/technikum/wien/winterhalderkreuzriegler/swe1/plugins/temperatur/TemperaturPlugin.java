package at.technikum.wien.winterhalderkreuzriegler.swe1.plugins.temperatur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		System.out.println("TemperaturPlugin gestartet");
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:temperatureplugin@//localhost:1521/xe",
					"temperatureplugin", "123456");

			Statement stmt = conn.createStatement();

			ResultSet rset = stmt
					.executeQuery("select firstname from temperatureplugin.testtable");
			while (rset.next())
				System.out.println(rset.getString(1)); // Print col 1
			rset.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}

	}

	@Override
	public void stop() {
		// TODO Hier wird der Thread, der die Serverdaten ausliest beendet
		System.out.println("TemperaturPlugin beendet");
	}

}
