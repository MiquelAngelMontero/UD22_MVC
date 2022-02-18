

import modelo.conexion.Conexion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Conexion BD = new Conexion();
    	BD.enableConnection();
    }
}
