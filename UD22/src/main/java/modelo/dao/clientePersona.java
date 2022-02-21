package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.dto.clienteTab;

public class clientePersona {
	public void registrarPersona(clienteTab person) {
		Conexion conexion= new Conexion();
		
		try {
			Statement st = conexion.getConnection().createStatement();
			String sql= "INSERT INTO cliente VALUES ('"+person.getId()+"', '"
					+person.getNombre()+"', '"+person.getApellido()+"', '"
					+person.getDireccion()+"', '"+person.getDni()+"', '"
					+person.getFecha()+"');";
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
	
	public clienteTab buscarPersona(int codigo) {
		Conexion conexion= new Conexion();
		clienteTab client= new clienteTab();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM cliente where id = ? ";
			PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				client.setId(Integer.parseInt(res.getString("id")));
				client.setNombre(res.getString("nombre"));
				client.setApellido(res.getString("apellido"));
				client.setDireccion(res.getString("direccion"));
				client.setDni(res.getString("dni"));
				client.setFecha(res.getString("fecha"));
			 }
			res.close();
			conexion.closeConnection();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return client;
			}
			else return null;				
	}
	
	public void modificarPersona(clienteTab person) {
			
			Conexion conex= new Conexion();
			try{
				String consulta="UPDATE cliente SET id= ? ,nombre = ? , apellido=? , direccion=? , dni= ?, fecha= ? WHERE id= ? ";
				PreparedStatement upd = conex.getConnection().prepareStatement(consulta);
				
				upd.setInt(1, person.getId());
				upd.setString(2, person.getNombre());
				upd.setString(3, person.getApellido());
				upd.setString(4, person.getDireccion());
				upd.setString(5,person.getDni());
				upd.setString(6, person.getFecha());
				upd.setInt(7, person.getId());
				upd.executeUpdate();
	            
	          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
	          System.out.println(consulta);
	         
	
	        }catch(SQLException	 e){
	            System.out.println(e);
	            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);
	        }
		}
	
	public void eliminarPersona(String codigo){
		Conexion conexion= new Conexion();
		try {
			String sql= "DELETE FROM cliente WHERE id='"+codigo+"'";
			Statement st = conexion.getConnection().createStatement();
			st.executeUpdate(sql);
	        JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
	        System.out.println(sql);
			st.close();
			conexion.closeConnection();
			
		} catch (SQLException e) {
	        System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
