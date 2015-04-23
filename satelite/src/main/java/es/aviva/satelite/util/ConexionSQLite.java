package es.aviva.satelite.util;

import java.sql.*;

/**
 *
 * @author Santiago
 */
public class ConexionSQLite {
    
	private static final String driver = "org.sqlite.JDBC";;
    public String url, ip, bd, usr, pass;
    public static Connection conexion;
    private static String fichBD;

    public ConexionSQLite() {
    }
    
    public static Connection getConexion(String fichero) {
    	fichBD=fichero;
    	if(conexion==null)
    		conexion=abreConexion();
    	return conexion;
    }
    
    private static Connection abreConexion(){
        
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection("jdbc:sqlite:"+fichBD);
            System.out.println("Conexion a Base de Datos " + fichBD + " Ok");
            return conexion;
        } catch (Exception exc) {
            System.out.println("Error al tratar de abrir la base de Datos" + fichBD + " : " + exc);
            return null;
        }
    }
    
    public Connection cerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        return conexion;
    }
        
}