package Modelo.dao;

import Conexion.Conexion;
import Modelo.dto.asignado_a;

import java.sql.*;

import javax.swing.JOptionPane;

public class asignado_aDao {

		public void registrarasignado_a(asignado_a miasignado_a){
			Connection conex= null;
			
			try {
				conex = Conexion.conectar();
				Statement st = conex.createStatement();
				String sql= "INSERT INTO asignado_a VALUES ('"+miasignado_a.getCientifico()+"', '"
						+miasignado_a.getProyecto()+"');";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(sql);
				st.close();
				conex.close();;
				
			} catch (SQLException e) {
	            System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "No se Registro");
			}
		}

		public asignado_a buscarasignado_a(String codigoasignado_a) 
		{
			Connection conex= null;
			asignado_a asignado_a= new asignado_a();
			boolean existe=false;
			try {
				conex = Conexion.conectar();
				String sql= "SELECT * FROM asignado_a where id = ? ";
				PreparedStatement consulta = conex.prepareStatement(sql);
				consulta.setString(1, codigoasignado_a);
				ResultSet res = consulta.executeQuery();
				while(res.next()){
					existe=true;
					asignado_a.setCientifico(res.getString("cientifico"));
					asignado_a.setProyecto(res.getString("proyecto"));
				res.close();
				conex.close();
				System.out.println(sql);
				}		
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
			
			
			if (existe) {
				return asignado_a;
			}
			else return null;				
		}
		
		

		public void modificarasignado_a(asignado_a miasignado_a) {
			
			Connection conex= null;
			try{
				conex = Conexion.conectar();
				String consulta="UPDATE asignado_a SET id= ? ,nombre = ? , edad=? , profesion=? , telefono= ? WHERE id= ? ";
				PreparedStatement estatuto = conex.prepareStatement(consulta);
				
	            estatuto.setString(1, miasignado_a.getCientifico());
	            estatuto.setString(2, miasignado_a.getProyecto());
	            estatuto.setString(3, miasignado_a.getCientifico());
	            estatuto.executeUpdate();
	            
	          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
	          System.out.println(consulta);
	         

	        }catch(SQLException	 e){

	            System.out.println(e);
	            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

	        }
		}

		public void eliminarasignado_a(String codigo)
		{
			Connection conex= null;
			try {
				conex = Conexion.conectar();
				String sql= "DELETE FROM asignado_a WHERE id='"+codigo+"'";
				Statement st = conex.createStatement();
				st.executeUpdate(sql);
	            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
	            System.out.println(sql);
				st.close();
				conex.close();
				
			} catch (SQLException e) {
	            System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(null, "No se Elimino");
			}
		}

	}	



