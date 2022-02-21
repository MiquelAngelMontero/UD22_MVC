package Modelo.dao;

import Conexion.Conexion;
import Modelo.dto.Cientifico;

import java.sql.*;

import javax.swing.JOptionPane;

public class CientificoDao {

		public void registrarCientifico(Cientifico miCientifico){
			Connection conex= null;
			
			try {
				conex = Conexion.conectar();
				Statement st = conex.createStatement();
				String sql= "INSERT INTO Cientifico VALUES ('"+miCientifico.getDni()+"', '"
						+miCientifico.getNomApels()+"');";
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

		public Cientifico buscarCientifico(String codigoCientifico) 
		{
			Connection conex= null;
			Cientifico Cientifico= new Cientifico();
			boolean existe=false;
			try {
				conex = Conexion.conectar();
				String sql= "SELECT * FROM Cientifico where id = ? ";
				PreparedStatement consulta = conex.prepareStatement(sql);
				consulta.setString(1, codigoCientifico);
				ResultSet res = consulta.executeQuery();
				while(res.next()){
					existe=true;
					Cientifico.setDni(res.getString("dni"));
					Cientifico.setNomApels(res.getString("nomApels"));
				res.close();
				conex.close();
				System.out.println(sql);
				}		
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
			
			
			if (existe) {
				return Cientifico;
			}
			else return null;				
		}
		
		

		public void modificarCientifico(Cientifico miCientifico) {
			
			Connection conex= null;
			try{
				conex = Conexion.conectar();
				String consulta="UPDATE Cientifico SET id= ? ,nombre = ? , edad=? , profesion=? , telefono= ? WHERE id= ? ";
				PreparedStatement estatuto = conex.prepareStatement(consulta);
				
	            estatuto.setString(1, miCientifico.getDni());
	            estatuto.setString(2, miCientifico.getNomApels());
	            estatuto.setString(3, miCientifico.getDni());
	            estatuto.executeUpdate();
	            
	          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
	          System.out.println(consulta);
	         

	        }catch(SQLException	 e){

	            System.out.println(e);
	            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

	        }
		}

		public void eliminarCientifico(String codigo)
		{
			Connection conex= null;
			try {
				conex = Conexion.conectar();
				String sql= "DELETE FROM Cientifico WHERE id='"+codigo+"'";
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

