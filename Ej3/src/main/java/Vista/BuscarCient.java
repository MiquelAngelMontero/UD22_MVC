package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Control.ControlCient;
import Modelo.dto.Cientifico;
import Modelo.service.CientificoService;

public class BuscarCient extends JFrame implements ActionListener {

private static final long serialVersionUID = 1L;
	
	private ControlCient CientificoController; //objeto CientificoController que permite la relacion entre esta clase y la clase CientificoController
	private JLabel labelTitulo;
	private JTextField textDni,textNomApels;
	private JLabel nombre,profesion;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public BuscarCient() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR CientificoS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		
		nombre=new JLabel();
		nombre.setText("Dni");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);

		
		profesion=new JLabel();
		profesion.setText("Nombre y apellidos");
		profesion.setBounds(20, 160, 80, 25);
		add(profesion);
		
		textDni=new JTextField();
		textDni.setBounds(80, 120, 190, 25);
		add(textDni);
		
		textNomApels=new JTextField();
		textNomApels.setBounds(80, 160, 190, 25);
		add(textNomApels);

		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		add(botonCancelar);
		add(botonBuscar);
		add(botonModificar);
		add(botonEliminar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	public void setCoordinador(ControlCient CientificoController) {
		this.CientificoController=CientificoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cientifico miCientifico=new Cientifico();
				miCientifico.setDni(textDni.getText());
				miCientifico.setNomApels(textNomApels.getText());

				CientificoController.modificarCientifico(miCientifico);
				
				if (CientificoService.modificaCientifico==true) {
					habilita(true, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cientifico miCientifico=CientificoController.buscarCientifico(textDni.getText());
			if (miCientifico!=null)
			{
				muestraCientifico(miCientifico);
			}
			else if(CientificoService.consultaCientifico==true){
				JOptionPane.showMessageDialog(null, "La Cientifico no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, false, true, true);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textDni.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Cientifico?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					CientificoController.eliminarCientifico(textDni.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la Cientifico consultada
	 * @param miCientifico
	 */
	private void muestraCientifico(Cientifico miCientifico) {
		textDni.setText(miCientifico.getDni());
		textNomApels.setText(miCientifico.getNomApels());
		habilita(true, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textDni.setText("");
		textNomApels.setText("");
		habilita(true, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param edad
	 * @param tel
	 * @param profesion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean dni, boolean nomApels,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textDni.setEditable(dni);
		textNomApels.setEditable(nomApels);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}

	
}
