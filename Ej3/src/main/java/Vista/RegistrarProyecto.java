package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Control.ControlProyecto;
import Modelo.dto.proyecto;

public class RegistrarProyecto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ControlProyecto ControlProyecto; //objeto ControlProyecto que permite la relacion entre esta clase y la clase ControlProyecto
	private JLabel labelTitulo;
	private JTextField textId,textNombre, texthoras;
	private JLabel cod,nombre,horas;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public RegistrarProyecto() {

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
		cod.setText("Id");
		cod.setBounds(20, 80, 80, 25);
		add(cod);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);
		
		horas=new JLabel();
		horas.setText("Horas");
		horas.setBounds(20, 160, 80, 25);
		add(horas);
		
		textId=new JTextField();
		textId.setBounds(80, 80, 80, 25);
		add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		add(textNombre);
		
		texthoras=new JTextField();
		texthoras.setBounds(80, 160, 190, 25);
		add(texthoras);
		
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
		textId.setText("");
		textNombre.setText("");
		texthoras.setText("");
	}


	public void setCoordinador(ControlProyecto ControlProyecto) {
		this.ControlProyecto=ControlProyecto;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				proyecto miProyecto=new proyecto();
				miProyecto.setId(textId.getText());
				miProyecto.setNombre(textNombre.getText());
				miProyecto.setHoras(Integer.parseInt(textNombre.getText()));
				
				ControlProyecto.registrarProyecto(miProyecto);;	
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
