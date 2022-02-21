package Modelo.dao;

import Conexion.Conexion;
import Modelo.dto.proyecto;

import java.sql.*;

import javax.swing.JOptionPane;

public class ProyectoDao {

		public void registrarproyecto(proyecto miproyecto){
			Connection conex= null;
			
			try {
				conex = Conexion.conectar();
				Statement st = conex.createStatement();
				String sql= "INSERT INTO proyecto VALUES ('"+miproyecto.getId()+"', '"
						+"', '"+miproyecto.getNombre()+"', '"+miproyecto.getHoras()+"');";
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

		public proyecto buscarproyecto(String codigoproyecto) 
		{
			Connection conex= null;
			proyecto proyecto= new proyecto();
			boolean existe=false;
			try {
				conex = Conexion.conectar();
				String sql= "SELECT * FROM proyecto where id = ? ";
				PreparedStatement consulta = conex.prepareStatement(sql);
				consulta.setString(1, codigoproyecto);
				ResultSet res = consulta.executeQuery();
				while(res.next()){
					existe=true;
					proyecto.setId(res.getString("id"));
					proyecto.setNombre(res.getString("nombre"));
					proyecto.setHoras(Integer.parseInt(res.getString("horas")));
				res.close();
				conex.close();
				System.out.println(sql);
				}		
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
			
			
			if (existe) {
				return proyecto;
			}
			else return null;				
		}
		
		

		public void modificarproyecto(proyecto miproyecto) {
			
			Connection conex= null;
			try{
				conex = Conexion.conectar();
				String consulta="UPDATE proyecto SET id= ? ,nombre = ? , edad=? , profesion=? , telefono= ? WHERE id= ? ";
				PreparedStatement estatuto = conex.prepareStatement(consulta);
				
	            estatuto.setString(1, miproyecto.getId());
	            estatuto.setString(2, miproyecto.getNombre());
	            estatuto.setInt(3, miproyecto.getHoras());
	            estatuto.setString(4, miproyecto.getId());
	            estatuto.executeUpdate();
	            
	          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
	          System.out.println(consulta);
	         

	        }catch(SQLException	 e){

	            System.out.println(e);
	            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

	        }
		}

		public void eliminarproyecto(String codigo)
		{
			Connection conex= null;
			try {
				conex = Conexion.conectar();
				String sql= "DELETE FROM proyecto WHERE id='"+codigo+"'";
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


