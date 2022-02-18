package Vista;

import javax.swing.*;

public class Mostrar extends JFrame {

	private JPanel contentPane;
	private JMenu archivo;
	private JMenuItem sentenciaLibre, borrarTodo;

	public Mostrar() {
		
		setTitle("Opciones");//Titulo
		
		JMenuBar barraMenu = new JMenuBar();
		
		archivo = new JMenu("Archivo");
		
		sentenciaLibre = new JMenuItem("Introducir Sentencia SQL");
		
		borrarTodo = new JMenuItem("Limpiar BBDD");
		
		archivo.add(sentenciaLibre);
		
		archivo.add(borrarTodo);
		
		barraMenu.add(archivo);
		
		setJMenuBar(barraMenu);
		
		setBounds(870, 300, 300, 300);//Posicion
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
		contentPane = new JPanel();
		
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
	}
	
}
