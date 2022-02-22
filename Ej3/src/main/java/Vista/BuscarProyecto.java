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
import Modelo.service.proyectoService;

public class BuscarProyecto extends JFrame implements ActionListener {

private static final long serialVersionUID = 1L;
	
	private ControlProyecto ProyectoController; //objeto ProyectoController que permite la relacion entre esta clase y la clase ProyectoController
	private JLabel labelTitulo;
	private JTextField textId,textNombre, textHoras;
	private JLabel nombre,profesion, horas;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public BuscarProyecto() {

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
		labelTitulo.setText("ADMINISTRAR ProyectoS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		
		nombre=new JLabel();
		nombre.setText("Id");
		nombre.setBounds(20, 120, 80, 25);
		add(nombre);

		
		profesion=new JLabel();
		profesion.setText("Nombre");
		profesion.setBounds(20, 160, 80, 25);
		add(profesion);
		
		horas=new JLabel();
		horas.setText("Horas");
		horas.setBounds(20, 200, 80, 25);
		add(horas);
		
		textId=new JTextField();
		textId.setBounds(80, 120, 190, 25);
		add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 160, 190, 25);
		add(textNombre);
		
		textHoras=new JTextField();
		textHoras.setBounds(80, 200, 190, 25);
		add(textHoras);

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


	public void setCoordinador(ControlProyecto ProyectoController) {
		this.ProyectoController=ProyectoController;
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

				ProyectoController.modificarProyecto(miProyecto);
				
				if (proyectoService.modificaproyecto==true) {
					habilita(true, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			proyecto miProyecto=ProyectoController.buscarProyecto(textId.getText());
			if (miProyecto!=null)
			{
				muestraProyecto(miProyecto);
			}
			else if(proyectoService.consultaproyecto==true){
				JOptionPane.showMessageDialog(null, "La Proyecto no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, false, true, true);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Proyecto?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					ProyectoController.eliminarProyecto(textId.getText());
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
	 * permite cargar los datos de la Proyecto consultada
	 * @param miProyecto
	 */
	private void muestraProyecto(proyecto miProyecto) {
		textId.setText(miProyecto.getId());
		textNombre.setText(miProyecto.getNombre());
		textHoras.setText(miProyecto.getHoras()+"");
		habilita(true, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textId.setText("");
		textNombre.setText("");
		textHoras.setText("");
		habilita(true, false, false, true, false, true, true);
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
	public void habilita(boolean id, boolean nombre, boolean horas, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(id);
		textNombre.setEditable(nombre);
		textHoras.setEditable(horas);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
	
}
