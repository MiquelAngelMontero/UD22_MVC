package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.dto.videosTab;

public class videosCliente {
	public void registrarPersona(videosTab person) {
		Conexion conexion= new Conexion();
		
		try {
			Statement st = conexion.getConnection().createStatement();
			String sql= "INSERT INTO videos VALUES ('"+person.getId()+"', '"
					+person.getTitle()+"', '"+person.getDirector()+"', '"
					+person.getCli_id()+"');";
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
	
	public videosTab buscarPersona(int codigo) {
		Conexion conexion= new Conexion();
		videosTab client= new videosTab();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM videos where id = ? ";
			PreparedStatement consulta = conexion.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				client.setId(Integer.parseInt(res.getString("id")));
				client.setTitle(res.getString("title"));
				client.setDirector(res.getString("director"));
				client.setCli_id(Integer.parseInt(res.getString("cli_id")));

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
	
	public void modificarPersona(videosTab person) {
			
			Conexion conex= new Conexion();
			try{
				String consulta="UPDATE videos SET id= ? ,tile = ? , director=? WHERE cli_id= ? ";
				PreparedStatement upd = conex.getConnection().prepareStatement(consulta);
				
				upd.setInt(1, person.getId());
				upd.setString(2, person.getTitle());
				upd.setString(3, person.getDirector());
				upd.setInt(5, person.getId());
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
			String sql= "DELETE FROM videos WHERE cli_id='"+codigo+"'";
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
