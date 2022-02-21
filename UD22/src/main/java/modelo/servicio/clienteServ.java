package modelo.servicio;
import javax.swing.JOptionPane;

import control.controlGeneral;
import modelo.dao.clientePersona;
import modelo.dto.clienteTab;


public class clienteServ {
	private controlGeneral cliController; 
	public static boolean consultaPersona=false;
	public static boolean modificaPersona=false;
	
	//Metodo de vinculación con el controller principal
	public void setcontrolGeneral(controlGeneral clienteController) {
		this.setController(clienteController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(clienteTab cliente) {
		clientePersona miPersonaDao;
		if (cliente.getId() > 99) {
			miPersonaDao = new clientePersona();
			miPersonaDao.registrarPersona(cliente);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public clienteTab validarConsulta(String codigoPersona) {
		clientePersona personaCliente;
		
		try {
			int codigo=Integer.parseInt(codigoPersona);	
			if (codigo > 99) {
				personaCliente = new clientePersona();
				consultaPersona=true;
				return personaCliente.buscarPersona(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento de la persona debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaPersona=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaPersona=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaPersona=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(clienteTab cliente) {
		clientePersona clientePersona;
		if (cliente.getNombre().length()>5) {
			clientePersona = new clientePersona();
			clientePersona.modificarPersona(cliente);	
			modificaPersona=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre de la persona debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaPersona=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		clientePersona miPersonaDao=new clientePersona();
		miPersonaDao.eliminarPersona(codigo);
	}

	
	
	public controlGeneral getClienteController() {
		return cliController;
	}

	public void setController(controlGeneral cliController) {
		this.cliController = cliController;
	}


}
