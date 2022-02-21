package UD22.UD22;


import modelo.conexion.Conexion;
import vista.VentanaPrincipal;

/**
 * Hello world!
 *
 */
public class App {
	VentanaPrincipal ventanaGeneral;
    public static void main( String[] args ) {
    	App run = new App();
    	run.iniciar();
    }
    
    private void iniciar() {
		/*Se instancian las clases*/
    	ventanaGeneral=new VentanaPrincipal();

		
		/*Se establecen las relaciones entre clases*/
    	//ventanaGeneral.setCoordinador(personaController);

		
		/*Se establecen relaciones con la clase coordinador*/

				
    	ventanaGeneral.setVisible(true);
	}

}


