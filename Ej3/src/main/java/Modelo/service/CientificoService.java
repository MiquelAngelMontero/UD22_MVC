package Modelo.service;

import javax.swing.JOptionPane;

import Control.ControlAsignado;
import Modelo.dao.CientificoDao;
import Modelo.dto.Cientifico;

public class CientificoService {

	private ControlAsignado CientificoController; 
	public static boolean consultaCientifico=false;
	public static boolean modificaCientifico=false;
	
	//Metodo de vinculación con el controller principal
	public void setCientificoController(ControlAsignado CientificoController) {
		this.setController(CientificoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getDni().length() == 9) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.registrarCientifico(miCientifico);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento de la Cientifico debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cientifico validarConsulta(String codigoCientifico) {
		CientificoDao miCientificoDao;
		
		try {
			if (codigoCientifico.length() == 9) {
				miCientificoDao = new CientificoDao();
				consultaCientifico=true;
				return miCientificoDao.buscarCientifico(codigoCientifico);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la Cientifico debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaCientifico=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getDni().length()==9) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.modificarCientifico(miCientifico);	
			modificaCientifico=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la Cientifico debe igual a 9 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaCientifico=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		CientificoDao miCientificoDao=new CientificoDao();
		miCientificoDao.eliminarCientifico(codigo);
	}

	
	
	public ControlAsignado getCientificoController() {
		return CientificoController;
	}

	public void setController(ControlAsignado CientificoController) {
		this.CientificoController = CientificoController;
	}
	
}
