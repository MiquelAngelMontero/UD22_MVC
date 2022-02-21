package UD22.UD22.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import UD22.UD22.Control.ClienteController;
import UD22.UD22.Modelo.dto.Cliente;
import UD22.UD22.Modelo.dto.ClienteServ;

public class VentanaBuscar extends JFrame implements ActionListener{

private static final long serialVersionUID = 1L;
	
	private ClienteController ClienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textID,textNombre,textApellido,textDireccion,textDNI,textFecha;
	private JLabel cod,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	
	public VentanaBuscar() {

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
		labelTitulo.setText("ADMINISTRAR ClienteS");
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


	public void setCoordinador(ClienteController ClienteController) {
		this.ClienteController=ClienteController;
	}

	/**
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int DNI;
	private Date fecha;
	 */
	
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

				ClienteController.modificarCliente(miCliente);
				
				if (ClienteServ.modificaCliente==true) {
					habilita(true, false, false, false, false, true, false, true, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cliente miCliente=ClienteController.buscarCliente(textID.getText());
			if (miCliente!=null)
			{
				muestraCliente(miCliente);
			}
			else if(ClienteServ.consultaCliente==true){
				JOptionPane.showMessageDialog(null, "La Cliente no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, true, false, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textID.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Cliente?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					ClienteController.eliminarCliente(textID.getText());
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
	 * permite cargar los datos de la Cliente consultada
	 * @param miCliente
	 */
	private void muestraCliente(Cliente miCliente) {
		textNombre.setText(miCliente.getNombre());
		textDNI.setText(miCliente.getDNI()+"");
		textApellido.setText(miCliente.getApellido());
		textDireccion.setText(miCliente.getDireccion()+"");
		textFecha.setText(miCliente.getFecha()+"");
		habilita(true, false, false, false, false, true, false, false, false, false);
	}

	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textID.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textDNI.setText("");
		textFecha.setText("");
		habilita(true, false, false, false, false, true, false, false, false, false);
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
	
	public void habilita(boolean id, boolean nombre, boolean apellido, boolean direccion, boolean DNI, boolean fecha, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textID.setEditable(id);
		textNombre.setEditable(nombre);
		textApellido.setEditable(apellido);
		textDireccion.setEditable(direccion);
		textDNI.setEditable(DNI);
		textFecha.setEditable(fecha);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}

	
}
