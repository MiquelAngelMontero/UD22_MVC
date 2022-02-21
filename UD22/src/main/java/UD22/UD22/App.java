package UD22.UD22;

import UD22.UD22.Modelo.dto.ClienteServ;
import UD22.UD22.Vista.VentanaBuscar;
import UD22.UD22.Vista.VentanaPrincipal;
import UD22.UD22.Vista.VentanaRegistro;
import UD22.UD22.Control.ClienteController;

public class App 
{
    	ClienteServ miClienteServ;
    	VentanaPrincipal miVentanaPrincipal;
    	VentanaBuscar miVentanaBuscar;
    	VentanaRegistro miVentanaRegistro;
    	ClienteController ClienteController;

    	/**
    	 * @param args
    	 */
    	
    	public static void main(String[] args) {
    		App miPrincipal=new App();
    		miPrincipal.iniciar();
    	}

    	/**
    	 * Permite instanciar todas las clases con las que trabaja
    	 * el sistema
    	 */
    	
    	private void iniciar() {
    		/*Se instancian las clases*/
    		miVentanaPrincipal=new VentanaPrincipal();
    		miVentanaRegistro=new VentanaRegistro();
    		miVentanaBuscar= new VentanaBuscar();
    		miClienteServ=new ClienteServ();
    		ClienteController= new ClienteController();
    		
    		/*Se establecen las relaciones entre clases*/
    		miVentanaPrincipal.setCoordinador(ClienteController);
    		miVentanaRegistro.setCoordinador(ClienteController);
    		miVentanaBuscar.setCoordinador(ClienteController);
    		miClienteServ.setClienteController(ClienteController);
    		
    		/*Se establecen relaciones con la clase coordinador*/
    		ClienteController.setMiVentanaPrincipal(miVentanaPrincipal);
    		ClienteController.setMiVentanaRegistro(miVentanaRegistro);
    		ClienteController.setMiVentanaBuscar(miVentanaBuscar);
    		ClienteController.setClienteServ(miClienteServ);
    		
    		miVentanaPrincipal.setVisible(true);
    	}


    }
