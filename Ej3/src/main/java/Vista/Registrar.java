package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Control.ControlAsignado;
import Modelo.dto.asignado_a;

public class Registrar extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ControlAsignado asignado_aController; //objeto asignado_aController que permite la relacion entre esta clase y la clase asignado_aController
	private JLabel labelTitulo;
	private JTextField textCient,textProj;
	private JLabel cod,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public Registrar() {

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
		cod.setText("Cientifico");
		cod.setBounds(20, 80, 80, 25);
		add(cod);
		
		nombre=new JLabel();
		nombre.setText("Proyecto");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);
		
		textCient=new JTextField();
		textCient.setBounds(80, 80, 80, 25);
		add(textCient);
		
		textProj=new JTextField();
		textProj.setBounds(80, 120, 190, 25);
		add(textProj);
		
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
		textCient.setText("");
		textProj.setText("");
	}


	public void setCoordinador(ControlAsignado asignado_aController) {
		this.asignado_aController=asignado_aController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				asignado_a miasignado_a=new asignado_a();
				miasignado_a.setCientifico(textCient.getText());
				miasignado_a.setProyecto(textProj.getText());
				
				asignado_aController.registrarasignado_a(miasignado_a);	
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


