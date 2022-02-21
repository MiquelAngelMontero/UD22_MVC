package Modelo.service;

import javax.swing.JOptionPane;

import Control.ControlAsignado;
import Modelo.dao.ProyectoDao;
import Modelo.dto.proyecto;

public class proyectoService {

		private ControlAsignado proyectoController; 
		public static boolean consultaproyecto=false;
		public static boolean modificaproyecto=false;
		
		//Metodo de vinculación con el controller principal
		public void setproyectoController(ControlAsignado proyectoController) {
			this.setController(proyectoController);		
		}

		//Metodo que valida los datos de Registro antes de pasar estos al DAO
		public void validarRegistro(proyecto miproyecto) {
			ProyectoDao miproyectoDao;
			if (miproyecto.getId().length() == 4) {
				miproyectoDao = new ProyectoDao();
				miproyectoDao.registrarproyecto(miproyecto);						
			}else {
				JOptionPane.showMessageDialog(null,"El documento de la proyecto debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
		
		//Metodo que valida los datos de consulta antes de pasar estos al DAO
		public proyecto validarConsulta(String codigoproyecto) {
			ProyectoDao miproyectoDao;
			
			try {
				if (codigoproyecto.length() == 4) {
					miproyectoDao = new ProyectoDao();
					consultaproyecto=true;
					return miproyectoDao.buscarproyecto(codigoproyecto);						
				}else{
					JOptionPane.showMessageDialog(null,"El documento de la proyecto debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
					consultaproyecto=false;
				}
				
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
				consultaproyecto=false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
				consultaproyecto=false;
			}
						
			return null;
		}

		//Metodo que valida los datos de Modificación antes de pasar estos al DAO
		public void validarModificacion(proyecto miproyecto) {
			ProyectoDao miproyectoDao;
			if (miproyecto.getId().length()==9) {
				miproyectoDao = new ProyectoDao();
				miproyectoDao.modificarproyecto(miproyecto);	
				modificaproyecto=true;
			}else{
				JOptionPane.showMessageDialog(null,"El nombre de la proyecto debe igual a 9 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaproyecto=false;
			}
		}

		//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
		public void validarEliminacion(String codigo) {
			ProyectoDao miproyectoDao=new ProyectoDao();
			miproyectoDao.eliminarproyecto(codigo);
		}

		
		
		public ControlAsignado getproyectoController() {
			return proyectoController;
		}

		public void setController(ControlAsignado proyectoController) {
			this.proyectoController = proyectoController;
		}

	
}
