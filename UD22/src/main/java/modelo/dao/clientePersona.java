package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.dto.clienteTab;

public class clientePersona {
	public void registrarPersona(clienteTab miPersona) {
		Conexion conexion= new Conexion();
		
		try {
			Statement st = conexion.getConnection().createStatement();
			String sql= "INSERT INTO persona VALUES ('"+miPersona.getId()+"', '"
					+miPersona.getNombre()+"', '"+miPersona.getApellido()+"', '"
					+miPersona.getDireccion()+"', '"+miPersona.getDni()+"', '"
					+miPersona.getFecha()+"');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conexion.closeConnection();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

}
