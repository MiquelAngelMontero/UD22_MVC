package vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.controlGeneral;
import modelo.dto.clienteTab;
import modelo.servicio.clienteServ;


public class vistaBuscar extends JFrame implements ActionListener {
private static final long serialVersionUID = 1L;
	
	private controlGeneral controlGeneral; //objeto personaController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textDNI,textApellido,textDireccion,textFecha;
	private JLabel cod,nombre,dni,apellido,direccion, fecha;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public vistaBuscar() {

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
		labelTitulo.setText("ADMINISTRAR PERSONAS");
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

		apellido=new JLabel();
		apellido.setText("apellido");
		apellido.setBounds(290, 160, 80, 25);
		add(apellido);
		
		direccion=new JLabel();
		direccion.setText("direccion");
		direccion.setBounds(20, 160, 80, 25);
		add(direccion);
		
		dni=new JLabel();
		dni.setText("dni");
		dni.setBounds(290, 120, 80, 25);
		add(dni);
		
		fecha=new JLabel();
		fecha.setText("dni");
		fecha.setBounds(290, 100, 80, 25);
		add(fecha);
		
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		add(textCod);
		
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
		textFecha.setBounds(340, 100, 80, 25);
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

	/**
	public void setCoordinador(PersonaController personaController) {
		this.personaController=personaController;
	}**/


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				clienteTab client=new clienteTab();
				client.setId(Integer.parseInt(textCod.getText()));
				client.setNombre(textNombre.getText());
				client.setApellido(textApellido.getText());
				client.setDireccion(textDireccion.getText());
				client.setDni(textDNI.getText());
				client.setFecha(textFecha.getText());

				//personaController.modificarPersona(miPersona);
				
				if (clienteServ.modificaPersona==true) {
					habilita(true, false, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			clienteTab miPersona=controlGeneral.buscarPersona(textCod.getText());
			if (miPersona!=null)
			{
				muestraPersona(miPersona);
			}
			else if(clienteServ.consultaPersona==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(true, false, false, false, false, false, true, false, true, true);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCod.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Persona?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					controlGeneral.eliminarPersona(textCod.getText());
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
	 * permite cargar los datos de la persona consultada
	 * @param miPersona
	 */
	private void muestraPersona(clienteTab cliente) {
		textNombre.setText(cliente.getNombre());
		textApellido.setText(cliente.getApellido()+"");
		textDireccion.setText(cliente.getDireccion()+"");
		textDNI.setText(cliente.getDni());
		textFecha.setText(cliente.getFecha());
		habilita(true, false, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCod.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		textDNI.setText("");
		textFecha.setText("");
		habilita(true, false, false, false, false, false, true, false, true, true);
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
	public void habilita(boolean codigo, boolean nombre, boolean apellido, boolean dir, boolean dni, boolean fecha, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCod.setEditable(codigo);
		textNombre.setEditable(nombre);
		textApellido.setEditable(apellido);
		textDireccion.setEditable(dir);
		textDNI.setEditable(dni);
		textFecha.setEditable(fecha);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}

}
