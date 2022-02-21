package UD22.UD22.Modelo.dto;

import UD22.UD22.Control.ClienteController;
import javax.swing.JOptionPane;

public class ClienteServ {

	private ClienteController ClienteController;
	public static boolean consultaCliente = false;
	public static boolean modificaCliente = false;

	public void setClienteController(ClienteController ClienteController) {
		this.setController(ClienteController);
	}

	public void validarRegistro(Cliente miCliente) {
		ClienteDao miClienteDao;
		if (miCliente.getId() > 99) {
			miClienteDao = new ClienteDao();
			miClienteDao.registrarCliente(miCliente);
		} else {
			JOptionPane.showMessageDialog(null, "El documento de la Cliente debe ser mas de 3 digitos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);

		}

	}

	public Cliente validarConsulta(String codigoCliente) {
		ClienteDao miClienteDao;

		try {
			int codigo = Integer.parseInt(codigoCliente);
			if (codigo > 99) {
				miClienteDao = new ClienteDao();
				consultaCliente = true;
				return miClienteDao.buscarcliente(codigo);
			} else {
				JOptionPane.showMessageDialog(null, "El documento de la Cliente debe ser mas de 3 digitos",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				consultaCliente = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCliente = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaCliente = false;
		}

		return null;
	}

	public void validarModificacion(Cliente miCliente) {
		ClienteDao miClienteDao;
		if (miCliente.getNombre().length() > 5) {
			miClienteDao = new ClienteDao();
			miClienteDao.modificarCliente(miCliente);
			modificaCliente = true;
		} else {
			JOptionPane.showMessageDialog(null, "El nombre de la Cliente debe ser mayor a 5 digitos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			modificaCliente = false;
		}
	}

	public void validarEliminacion(String codigo) {
		ClienteDao miClienteDao = new ClienteDao();
		miClienteDao.eliminarcliente(codigo);
	}

	public ClienteController getClienteController() {
		return ClienteController;
	}

	public void setController(ClienteController ClienteController) {
		this.ClienteController = ClienteController;
	}

}
