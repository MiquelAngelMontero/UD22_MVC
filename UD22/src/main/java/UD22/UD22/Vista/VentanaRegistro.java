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
	private JLabel lblFecha;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistro() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(108, 329, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 329, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE ClienteS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("ID");
		cod.setBounds(10, 80, 80, 25);
		getContentPane().add(cod);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(10, 116, 80, 25);
		getContentPane().add(nombre);

		telefono=new JLabel();
		telefono.setText("Direccion");
		telefono.setBounds(10, 224, 80, 25);
		getContentPane().add(telefono);
		
		profesion=new JLabel();
		profesion.setText("Apellido");
		profesion.setBounds(10, 152, 80, 25);
		getContentPane().add(profesion);
		
		edad=new JLabel();
		edad.setText("DNI");
		edad.setBounds(10, 188, 80, 25);
		getContentPane().add(edad);
		
		textID=new JTextField();
		textID.setBounds(80, 80, 80, 25);
		getContentPane().add(textID);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 116, 190, 25);
		getContentPane().add(textNombre);

		textApellido=new JTextField();
		textApellido.setBounds(80, 224, 190, 25);
		getContentPane().add(textApellido);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(80, 188, 190, 25);
		getContentPane().add(textDireccion);
		
		textDNI=new JTextField();
		textDNI.setBounds(80, 152, 190, 25);
		getContentPane().add(textDNI);
		
		textFecha=new JTextField();
		textFecha.setBounds(80, 260, 80, 25);
		getContentPane().add(textFecha);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(481, 439);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		lblFecha = new JLabel();
		lblFecha.setText("Fecha");
		lblFecha.setBounds(10, 260, 80, 25);
		getContentPane().add(lblFecha);

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
