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

public class RegistrarCient extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ControlCient ControlCient; //objeto ControlCient que permite la relacion entre esta clase y la clase ControlCient
	private JLabel labelTitulo;
	private JTextField textDni,textNomApels;
	private JLabel cod,nombre;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public RegistrarCient() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE ASIGNADOS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("Dni");
		cod.setBounds(20, 80, 80, 25);
		add(cod);
		
		nombre=new JLabel();
		nombre.setText("Nombre y apellidos");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);
		
		textDni=new JTextField();
		textDni.setBounds(80, 80, 80, 25);
		add(textDni);
		
		textNomApels=new JTextField();
		textNomApels.setBounds(80, 120, 190, 25);
		add(textNomApels);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		add(botonCancelar);
		add(botonGuardar);
		add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}


	private void limpiar() 
	{
		textDni.setText("");
		textNomApels.setText("");
	}


	public void setCoordinador(ControlCient ControlCient) {
		this.ControlCient=ControlCient;
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
				
				ControlCient.registrarCientifico(miCientifico);;	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
}
