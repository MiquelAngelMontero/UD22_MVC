package control;

import modelo.dto.clienteTab;
import modelo.servicio.clienteServ;
import vista.vistaGeneral;

public class controlGeneral {
	private clienteServ clienteServ;
	private vistaGeneral vistaGen;
	
	public vistaGeneral getMiVentanaPrincipal() {
		return vistaGen;
	}
	public void setMiVentanaPrincipal(vistaGeneral vistaGen) {
		this.vistaGen = vistaGen;
	}
	
	public clienteServ getClienteServ() {
		return clienteServ;
	}
	public void getClienteServ(clienteServ clienteServ) {
		this.clienteServ = clienteServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	/**
		public void mostrarVentanaRegistro() {
			miVentanaRegistro.setVisible(true);
		}
		public void mostrarVentanaConsulta() {
			miVentanaBuscar.setVisible(true);
		}**/
		
		//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
		public void registrarPersona(clienteTab miPersona) {
			clienteServ.validarRegistro(miPersona);
		}
		
		public clienteTab buscarPersona(String codigoPersona) {
			return clienteServ.validarConsulta(codigoPersona);
		}
		
		public void modificarPersona(clienteTab miPersona) {
			clienteServ.validarModificacion(miPersona);
		}
		
		public void eliminarPersona(String codigo) {
			clienteServ.validarEliminacion(codigo);
		}



}
