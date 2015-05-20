package es.aviva.satelite.procesos.vt050052;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.aviva.satelite.util.ConexionSQLite;
import es.aviva.satelite.util.FileUtil;

public class Vt050052 {
	
	private static final Logger log = Logger.getLogger(Vt050052.class.getPackage().getName());
	private static final String FICH_PROPERTIES = "conf/vt050052.properties";
	private Vt050052Bean vt050052Bean = new Vt050052Bean();
	Connection conexion;
	
	public boolean procesar(){
	
		// Leemos del .properties:
	    if(!leerProperties()) {
	    	log.error("Error leyendo el fichero de configuración.");
	    	return false;
	    }
		
	    // Comprobamos si está activo el proceso
	    if(!vt050052Bean.isActivo()){
	    	log.info("Proceso desactivado en fichero properties.");
	    	return true;
	    }
	    
		// Comprobamos si existe el fichero origen
	    if(!FileUtil.existeFichero(vt050052Bean.getFicheroOrigen())){
	    	log.info("No existe el fichero origen: " + vt050052Bean.getFicheroOrigen());
    		return true;
    	}    
	    
		// Hacemos un backup del fichero
	    if(!FileUtil.backupTimeStamp(vt050052Bean.getFicheroOrigen(), vt050052Bean.getDirBackup())){
	    	log.error("No se ha podido hacer backup del fichero origen: " + vt050052Bean.getFicheroOrigen());
    		return false;
	    }

	    // Comprobamos que contenga información
	    if(FileUtil.isEmptyFile(vt050052Bean.getFicheroOrigen())){
	    	log.info("El fichero origen: " + vt050052Bean.getFicheroOrigen() + " no contiene información.");
    		return false;
    	}
	    
		// Comprobamos si existe el directorio destino.
		if(!FileUtil.existeFichero(vt050052Bean.getDirDestino())){
	    	log.info("El directorio destino: " + vt050052Bean.getDirDestino() + " no existe.");
    		return false;
		}
	    		
        // Abrimos la base de datos (conexión)
        conexion = ConexionSQLite.getConexion("db/"+vt050052Bean.getBaseDeDatos());
        if(conexion==null)
            return false;            
		
		
		// Importamos el fichero .dat en la base de datos de MsAccess
		
		// Borramos del directorio destino los caducados
		
		// Generamos los ficheros por cada mediador/asesor
		
		// Cerramos la base de datos de MsAccess
		
		// Generamos el fichero de estructura
		
		// Generamos el fichero indice para la web
		
		// Subimos los ficheros a la web
		
		// Enviar Mail de Aviso
	
	    return true;
	    
	}
	
	/**
	 * Método para leer el fichero de propiedades (.properties) del proceso Vt050013. 
	 * Lee el fichero y lo valida comprobando que estén todas las claves y que sus valores son correctos
	 * 
	 * @return (true/false)
	 */
	
	private boolean leerProperties(){
		
		Properties prop = new Properties();
		String clave;

		try{
			// Cargamos el fichero de propiedades en el Bean
			prop.load(new FileInputStream(FICH_PROPERTIES));
			
			vt050052Bean.setActivo(prop.getProperty("activo").equals("S"));
			vt050052Bean.setFicheroOrigen(prop.getProperty("ficheroOrigen"));
			vt050052Bean.setDirDestino(prop.getProperty("dirDestino"));
			//clave=prop.getProperty("ficheroPlano");
			//vt050052Bean.setFicheroPlano(prop.getProperty("ficheroPlano").equals("S"));
			//vt050052Bean.setFicheroExcel(prop.getProperty("ficheroExcel").equals("S"));
			vt050052Bean.setCaducaMeses(Integer.parseInt(prop.getProperty("caducaMeses")));
			vt050052Bean.setDirBackup(prop.getProperty("dirBackup"));
			vt050052Bean.setEmailTo(prop.getProperty("emailTo"));
			vt050052Bean.setEmailCC(prop.getProperty("emailCC"));
			vt050052Bean.setEmailFrom(prop.getProperty("emailFrom"));
			vt050052Bean.setTxtEmail(prop.getProperty("txtEmail"));
			vt050052Bean.setBaseDeDatos(prop.getProperty("basededatos"));
			return true;
		}catch(Exception e){
			log.error(e.getMessage());
			return false;
		}
			
	}

}