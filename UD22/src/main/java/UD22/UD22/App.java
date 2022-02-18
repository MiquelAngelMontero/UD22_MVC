package UD22.UD22;

import modelo.Conexion;

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
