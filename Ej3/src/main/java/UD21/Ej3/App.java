package UD21.Ej3;

import Control.ControlAsignado;
import Control.ControlCient;
import Control.ControlProyecto;
import Modelo.service.CientificoService;
import Modelo.service.asignado_aService;
import Modelo.service.proyectoService;
import Vista.BuscarCient;
import Vista.BuscarProyecto;
import Vista.Menu;
import Vista.Registrar;
import Vista.RegistrarCient;
import Vista.RegistrarProyecto;

public class App 
{
	
	ControlAsignado asignadoController;
	ControlCient cientController;
	ControlProyecto proyectoController;
	asignado_aService miAsignado_aService;
	CientificoService miCientificoService;
	proyectoService miProyectoService;
	BuscarCient BuscarCient;
	BuscarProyecto BuscarProyecto;
	Menu menu;
	Registrar RegistrarAsignado;
	RegistrarCient RegistrarCient;
	RegistrarProyecto RegistrarProyecto;
	
    public static void main( String[] args )
    {
    	
    	App main = new App();
    	
    	main.iniciar();
    	
    }
    
    private void iniciar() {
    	
    	asignadoController = new ControlAsignado();
    	cientController = new ControlCient();
    	proyectoController = new ControlProyecto();
    	miAsignado_aService = new asignado_aService();
    	miCientificoService = new CientificoService();
    	miProyectoService = new proyectoService();
    	BuscarCient = new BuscarCient();
    	BuscarProyecto = new BuscarProyecto();
    	menu = new Menu();
    	RegistrarAsignado = new Registrar();
    	RegistrarCient = new RegistrarCient();
    	RegistrarProyecto = new RegistrarProyecto();
    	
    	BuscarCient.setCoordinador(cientController);
    	BuscarProyecto.setCoordinador(proyectoController);
    	RegistrarAsignado.setCoordinador(asignadoController);
    	RegistrarCient.setCoordinador(cientController);
    	RegistrarProyecto.setCoordinador(proyectoController);
    	
    	asignadoController.setMiMenu(menu);
    	asignadoController.setMiVentanaRegistro(RegistrarAsignado);
    	asignadoController.setasignado_aService(miAsignado_aService);
    	
    	cientController.setCientificoServ(miCientificoService);
    	cientController.setMiBuscarCient(BuscarCient);
    	cientController.setMiMenu(menu);
    	cientController.setMiRegistrarCient(RegistrarCient);
    	
    	proyectoController.setMiBuscarProyecto(BuscarProyecto);
    	proyectoController.setMiMenu(menu);
    	proyectoController.setMiRegistrarProyecto(RegistrarProyecto);
    	proyectoController.setProyectoServ(miProyectoService);
    	
    	
    	
    }
    
}
