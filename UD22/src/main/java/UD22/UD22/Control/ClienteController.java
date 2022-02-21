package UD22.UD22.Control;

import UD22.UD22.Modelo.dto.Cliente;
import UD22.UD22.Modelo.dto.ClienteServ;
import UD22.UD22.Vista.VentanaBuscar;
import UD22.UD22.Vista.VentanaPrincipal;
import UD22.UD22.Vista.VentanaRegistro;

public class ClienteController {	
	
	private ClienteServ clienteServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistro miVentanaRegistro;
	private VentanaBuscar miVentanaBuscar;
	
	public ClienteServ getClienteServ() {
		return clienteServ;
	}

	public void setClienteServ(ClienteServ clienteServ) {
		this.clienteServ = clienteServ;
	}

	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaRegistro getMiVentanaRegistro() {
		return miVentanaRegistro;
	}

	public void setMiVentanaRegistro(VentanaRegistro miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}

	public VentanaBuscar getMiVentanaBuscar() {
		return miVentanaBuscar;
	}

	public void setMiVentanaBuscar(VentanaBuscar miVentanaBuscar) {
		this.miVentanaBuscar = miVentanaBuscar;
	}

	//Funcions de cliente
	public void modificarCliente(Cliente miCliente) {
		clienteServ.validarModificacion(miCliente);
	}

	public Cliente buscarCliente(String text) {
		return clienteServ.validarConsulta(text);
	}

	public void eliminarCliente(String text) {
		clienteServ.validarEliminacion(text);

	}
	
	public void registrarCliente(Cliente miCliente) {
		clienteServ.validarRegistro(miCliente);

	}
	
	//Mostrar Ventanas
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);

	}

	public void mostrarVentanaConsulta() {
		miVentanaBuscar.setVisible(true);

	}
}
