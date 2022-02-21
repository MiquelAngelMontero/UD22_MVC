package UD22.UD22.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import UD22.UD22.Control.ClienteController;
import UD22.UD22.Modelo.dto.Cliente;

public class VentanaRegistro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private ClienteController ClienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textID,textNombre,textApellido,textDireccion,textDNI,textFecha;
	private JLabel cod,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistro() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE ClienteS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 80, 80, 25);
		add(cod);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);

		telefono=new JLabel();
		telefono.setText("telefono");
		telefono.setBounds(290, 160, 80, 25);
		add(telefono);
		
		profesion=new JLabel();
		profesion.setText("profesion");
		profesion.setBounds(20, 160, 80, 25);
		add(profesion);
		
		edad=new JLabel();
		edad.setText("Edad");
		edad.setBounds(290, 120, 80, 25);
		add(edad);
		
		textID=new JTextField();
		textID.setBounds(80, 80, 80, 25);
		add(textID);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		add(textNombre);

		textApellido=new JTextField();
		textApellido.setBounds(340, 160, 80, 25);
		add(textApellido);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(80, 160, 190, 25);
		add(textDireccion);
		
		textDNI=new JTextField();
		textDNI.setBounds(340, 120, 80, 25);
		add(textDNI);
		
		textFecha=new JTextField();
		textFecha.setBounds(300, 160, 80, 25);
		add(textFecha);
		
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
		textID.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textDNI.setText("");
		textFecha.setText("");
	}


	public void setCoordinador(ClienteController ClienteController) {
		this.ClienteController=ClienteController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cliente miCliente=new Cliente();
				miCliente.setId(Integer.parseInt(textID.getText()));
				miCliente.setNombre(textNombre.getText());
				miCliente.setApellido(textApellido.getText());
				miCliente.setDireccion(textDNI.getText());
				miCliente.setDNI(Integer.parseInt(textDireccion.getText()));
				miCliente.setFecha(textFecha.getText());
				
				ClienteController.registrarCliente(miCliente);	
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
