package Modelo.service;

import javax.swing.JOptionPane;

import Control.ControlAsignado;
import Modelo.dao.asignado_aDao;
import Modelo.dto.asignado_a;

public class asignado_aService {
	
	private ControlAsignado asignado_aController; 
	public static boolean consultaasignado_a=false;
	public static boolean modificaasignado_a=false;
	
	//Metodo de vinculación con el controller principal
	public void setasignado_aController(ControlAsignado asignado_aController) {
		this.setController(asignado_aController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(asignado_a miasignado_a) {
		asignado_aDao miasignado_aDao;
		if (miasignado_a.getCientifico().length() == 9) {
			miasignado_aDao = new asignado_aDao();
			miasignado_aDao.registrarasignado_a(miasignado_a);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento de la asignado_a debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public asignado_a validarConsulta(String codigoasignado_a) {
		asignado_aDao miasignado_aDao;
		
		try {
			if (codigoasignado_a.length() == 9) {
				miasignado_aDao = new asignado_aDao();
				consultaasignado_a=true;
				return miasignado_aDao.buscarasignado_a(codigoasignado_a);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la asignado_a debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaasignado_a=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaasignado_a=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaasignado_a=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(asignado_a miasignado_a) {
		asignado_aDao miasignado_aDao;
		if (miasignado_a.getCientifico().length()==9) {
			miasignado_aDao = new asignado_aDao();
			miasignado_aDao.modificarasignado_a(miasignado_a);	
			modificaasignado_a=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la asignado_a debe igual a 9 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaasignado_a=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		asignado_aDao miasignado_aDao=new asignado_aDao();
		miasignado_aDao.eliminarasignado_a(codigo);
	}

	
	
	public ControlAsignado getasignado_aController() {
		return asignado_aController;
	}

	public void setController(ControlAsignado asignado_aController) {
		this.asignado_aController = asignado_aController;
	}



}

