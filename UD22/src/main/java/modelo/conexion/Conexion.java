package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	static String con = "jdbc:mysql://192.168.1.18:3306?useTimezone=true&serverTimezone=UTC";
	static String user = "remote";
	static String pass = "eE12345678";
	public static Connection conexion;
	//Metodo para conectarnos a la base de datos
	public void enableConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(con,user,pass);
			System.out.println("Conexion establecida");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("No se puede conectar a la BD");
			System.out.println(e);
		}
	}
	//Metodo para cerrar la sesion de la base de datos
	public void closeConnection() {
		try {
			conexion.close();
			System.out.println("Servidor desconectado");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error al cerrar conexion");
		}
	}
}
