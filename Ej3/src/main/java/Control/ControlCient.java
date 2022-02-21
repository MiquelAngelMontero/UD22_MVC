package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.dto.Cientifico;
import Modelo.service.CientificoService;
import Vista.BuscarCient;
import Vista.Menu;
import Vista.RegistrarCient;

public class ControlCient {

	private CientificoService CientificoServ;
	private Menu miMenu;
	private RegistrarCient miRegistrarCient;
	private BuscarCient miBuscarCient;
	
	//Metodos getter Setters de vistas
	public Menu getMiMenu() {
		return miMenu;
	}
	public void setMiMenu(Menu miMenu) {
		this.miMenu = miMenu;
	}
	public RegistrarCient getMiRegistrarCient() {
		return miRegistrarCient;
	}
	public void setMiRegistrarCient(RegistrarCient miRegistrarCient) {
		this.miRegistrarCient = miRegistrarCient;
	}
	public BuscarCient getMiBuscarCient() {
		return miBuscarCient;
	}
	public void setMiBuscarCient(BuscarCient miBuscarCient) {
		this.miBuscarCient = miBuscarCient;
	}
	public CientificoService getCientificoServ() {
		return CientificoServ;
	}
	public void setCientificoServ(CientificoService CientificoServ) {
		this.CientificoServ = CientificoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarRegistrarCient() {
		miRegistrarCient.setVisible(true);
	}
	public void mostrarVentanaConsulta() {
		miBuscarCient.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarCientifico(Cientifico miCientifico) {
		CientificoServ.validarRegistro(miCientifico);
	}
	
	public Cientifico buscarCientifico(String codigoCientifico) {
		return CientificoServ.validarConsulta(codigoCientifico);
	}
	
	public void modificarCientifico(Cientifico miCientifico) {
		CientificoServ.validarModificacion(miCientifico);
	}
	
	public void eliminarCientifico(String codigo) {
		CientificoServ.validarEliminacion(codigo);
	}

	
}
