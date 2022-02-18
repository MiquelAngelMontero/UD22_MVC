package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Menu  extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel titulo;
	public JButton botonBuscarCient, botonBuscarProyecto, botonRegistrarCient, botonRegistrarProyecto, botonAsignar;

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
			
		}
		
		if(e.getSource()==botonBuscarProyecto) {
					
		}
		
		if(e.getSource()==botonRegistrarCient) {
			
		}
		
		if(e.getSource()==botonRegistrarProyecto) {
			
		}
		
		if(e.getSource()==botonAsignar) {
			
		}
		
	}
}
