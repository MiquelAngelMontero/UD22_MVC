package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import Control.*;

import javax.swing.*;

public class Menu  extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel titulo;
	public JButton botonBuscarCient, botonBuscarProyecto, botonRegistrarCient, botonRegistrarProyecto, botonAsignar;
	private ControlAsignado cA;
	private ControlProyecto cP;
	private ControlCient cC;

	public Menu() {
		
		setTitle("Opciones");//Titulo
		
		setBounds(870, 300, 300, 300);//Posicion
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		titulo = new JLabel("Opciones disponibles");
		titulo.setBounds(85, 20, 150, 20);
		contentPane.add(titulo);
		
		botonBuscarCient = new JButton("Buscar Cientifico");
		botonBuscarCient.setBounds(55, 60, 170, 20);
		contentPane.add(botonBuscarCient);
		botonBuscarCient.addActionListener(this);
		
		botonBuscarProyecto = new JButton("Buscar Proyecto");
		botonBuscarProyecto.setBounds(55, 100, 170, 20);
		contentPane.add(botonBuscarProyecto);
		botonBuscarProyecto.addActionListener(this);
		
		botonRegistrarCient = new JButton("Registrar Cientifico");
		botonRegistrarCient.setBounds(55, 140, 170, 20);
		contentPane.add(botonRegistrarCient);
		botonRegistrarCient.addActionListener(this);
		
		botonRegistrarProyecto = new JButton("Registrar Proyecto");
		botonRegistrarProyecto.setBounds(55, 180, 170, 20);
		contentPane.add(botonRegistrarProyecto);		
		botonRegistrarProyecto.addActionListener(this);
		
		botonAsignar = new JButton("Asignar Cientifico");
		botonAsignar.setBounds(55, 220, 170, 20);
		contentPane.add(botonAsignar);
		botonAsignar.addActionListener(this);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==botonBuscarCient) {
			this.cC.mostrarVentanaConsulta();
		}
		
		if(e.getSource()==botonBuscarProyecto) {
			this.cP.mostrarVentanaConsulta();
		}
		
		if(e.getSource()==botonRegistrarCient) {
			this.cC.mostrarRegistrarCient();
		}
		
		if(e.getSource()==botonRegistrarProyecto) {
			this.cP.mostrarRegistrarProyecto();
		}
		
		if(e.getSource()==botonAsignar) {
			this.cA.mostrarVentanaRegistro();
		}
		
	}
}
