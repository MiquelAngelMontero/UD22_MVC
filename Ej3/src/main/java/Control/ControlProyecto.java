package Control;

import Modelo.dto.proyecto;
import Modelo.service.proyectoService;
import Vista.BuscarProyecto;
import Vista.BuscarProyecto;
import Vista.Menu;
import Vista.RegistrarProyecto;
import Vista.RegistrarProyecto;

public class ControlProyecto {

	private proyectoService ProyectoServ;
	private Menu miMenu;
	private RegistrarProyecto miRegistrarProyecto;
	private BuscarProyecto miBuscarProyecto;
	
	//Metodos getter Setters de vistas
	public Menu getMiMenu() {
		return miMenu;
	}
	public void setMiMenu(Menu miMenu) {
		this.miMenu = miMenu;
	}
	public RegistrarProyecto getMiRegistrarProyecto() {
		return miRegistrarProyecto;
	}
	public void setMiRegistrarProyecto(RegistrarProyecto miRegistrarProyecto) {
		this.miRegistrarProyecto = miRegistrarProyecto;
	}
	public BuscarProyecto getMiBuscarProyecto() {
		return miBuscarProyecto;
	}
	public void setMiBuscarProyecto(BuscarProyecto miBuscarProyecto) {
		this.miBuscarProyecto = miBuscarProyecto;
	}
	public proyectoService getProyectoServ() {
		return ProyectoServ;
	}
	public void setProyectoServ(proyectoService ProyectoServ) {
		this.ProyectoServ = ProyectoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarRegistrarProyecto() {
		miRegistrarProyecto.setVisible(true);
	}
	public void mostrarVentanaConsulta() {
		miBuscarProyecto.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarProyecto(proyecto miProyecto) {
		ProyectoServ.validarRegistro(miProyecto);
	}
	
	public proyecto buscarProyecto(String codigoProyecto) {
		return ProyectoServ.validarConsulta(codigoProyecto);
	}
	
	public void modificarProyecto(proyecto miProyecto) {
		ProyectoServ.validarModificacion(miProyecto);
	}
	
	public void eliminarProyecto(String codigo) {
		ProyectoServ.validarEliminacion(codigo);
	}
	
}
