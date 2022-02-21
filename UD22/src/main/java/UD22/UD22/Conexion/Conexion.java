package UD22.UD22.Conexion;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Conexion {

	static String bd = "T22_MVC";
	static String login = "remote";
	static String password = "Jordi123·";
	static String url = "jdbc:mysql://192.168.1.209/" + bd;

	Connection conn = null;

	public Conexion() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, login, password);

			if (conn != null) {
				System.out.print("Conexión a base de datos " + bd + "_SUCCESS at");
				fecha();
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public void desconectar() {
		conn = null;
	}

	// METODO QUE MUESTRA FECHA
	public static void fecha() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		System.out.println(" - " + hourdateFormat.format(date));
	}

}
