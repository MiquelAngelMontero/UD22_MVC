package Control;

import Modelo.dto.asignado_a;
import Vista.Menu;
import Vista.Registrar;

public class ControlAsignado {

	private Modelo.service.asignado_aService asignado_aService;
	private Menu miMenu;
	private Registrar miVentanaRegistro;
	
	//Metodos getter Setters de vistas
	public Menu getMiMenu() {
		return miMenu;
	}
	public void setMiMenu(Menu miMenu) {
		this.miMenu = miMenu;
	}
	public Registrar getMiVentanaRegistro() {
		return miVentanaRegistro;
	}
	public void setMiVentanaRegistro(Registrar miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}

	public Modelo.service.asignado_aService getasignado_aService() {
		return asignado_aService;
	}
	public void setasignado_aService(Modelo.service.asignado_aService asignado_aService) {
		this.asignado_aService = asignado_aService;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa Serviceice para validar los datos de las vistas
	public void registrarasignado_a(asignado_a miasignado_a) {
		asignado_aService.validarRegistro(miasignado_a);
	}
	
	public asignado_a buscarasignado_a(String codigoasignado_a) {
		return asignado_aService.validarConsulta(codigoasignado_a);
	}
	
	public void modificarasignado_a(asignado_a miasignado_a) {
		asignado_aService.validarModificacion(miasignado_a);
	}
	
	public void eliminarasignado_a(String codigo) {
		asignado_aService.validarEliminacion(codigo);
	}


	
}
