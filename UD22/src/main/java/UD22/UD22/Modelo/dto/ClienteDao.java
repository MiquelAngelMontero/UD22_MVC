package UD22.UD22.Modelo.dto;

import java.sql.*;
import javax.swing.*;
import UD22.UD22.Conexion.Conexion;

public class ClienteDao {

	public void registrarCliente(Cliente miCliente) {
		Conexion conex = new Conexion();

		try {
			Statement st = conex.getConnection().createStatement();
			String sql = "INSERT INTO Cliente VALUES ('" + miCliente.getId() + "', '" + miCliente.getNombre() + "', '"
					+ miCliente.getApellido() + "', '" + miCliente.getDireccion() + "', '" + miCliente.getDNI() + "', '"
					+ miCliente.getFecha() + "');'";
			
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public Cliente buscarcliente(int codigo) {
		Conexion conex = new Conexion();
		Cliente Cliente = new Cliente();
		boolean existe = false;
		try {
			String sql = "SELECT * FROM Cliente where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				existe = true;
				Cliente.setId(Integer.parseInt(res.getString("id")));
				Cliente.setNombre(res.getString("nombre"));
				Cliente.setApellido(res.getString("apellido"));
				Cliente.setDireccion(res.getString("direccion"));
				Cliente.setDNI(Integer.parseInt(res.getString("DNI")));
				Cliente.setFecha(""+res.getDate("fecha"));
			}
			res.close();
			conex.desconectar();
			System.out.println(sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}

		if (existe) {
			return Cliente;
		} else
			return null;
	}

	public void modificarCliente(Cliente miCliente) {

		Conexion conex = new Conexion();
		try {
			String consulta = "UPDATE Cliente SET id= ? ,nombre = ? , apellido= ? , direccion=? , DNI= ? , Fecha= ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);

			estatuto.setInt(1, miCliente.getId());
			estatuto.setString(2, miCliente.getNombre());
			estatuto.setString(3, miCliente.getApellido());
			estatuto.setString(4, miCliente.getDireccion());
			estatuto.setInt(5, miCliente.getDNI());
			estatuto.setString(6, miCliente.getFecha());
			estatuto.setInt(7, miCliente.getId());
			estatuto.executeUpdate();

			JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ", "Confirmación",
					JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);

		} catch (SQLException e) {

			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Error al Modificar", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void eliminarcliente(String codigo) {
		Conexion conex = new Conexion();
		try {
			String sql = "DELETE FROM Cliente WHERE id='" + codigo + "'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
