package es.aviva.satelite.procesos.vt050013;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.aviva.satelite.util.FileUtil;

public class Vt050013 {
	
	private static final Logger log = Logger.getLogger(Vt050013.class.getPackage().getName());
	private static final String FICH_PROPERTIES = "conf/vt050013.properties";
	private Vt050013Bean vt050013Bean = new Vt050013Bean();
	
	public boolean procesar(){
	
	
		// Leemos del .properties:
		// - path y nombre del fichero origen
		// - path destino
		// - ID del FTP
	    if(!leerProperties()) {
	    	log.error("Error leyendo el fichero de configuración.");
	    	return false;
	    }
		
		// Comprobamos si existe el fichero origen
	    if(!FileUtil.existeFichero(vt050013Bean.getFicheroOrigen())){
	    	log.info("No existe el fichero origen: " + vt050013Bean.getFicheroOrigen());
    		return false;
    	}
		
		// Comprobamos que contenga informaci�n
	    if(!FileUtil.isEmptyFile(vt050013Bean.getFicheroOrigen())){
	    	log.info("El fichero origen: " + vt050013Bean.getFicheroOrigen() + " no contiene informaci�n.");
    		return false;
    	}
		
		// Comprobamos si existe el directorio destino
		
	    
		// Hacemos un backup del fichero
	    if(!FileUtil.backupTimeStamp(vt050013Bean.getFicheroOrigen(), vt050013Bean.getDirBackup())){
	    	log.error("No se ha podido hacer backup del fichero origen: " + vt050013Bean.getFicheroOrigen());
    		return false;
	    }
		
		// Abrimos la base de datos de Access
		
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
	 * M�todo para leer el fichero de propiedades (.properties) del proceso Vt050013. 
	 * Lee el fichero y lo valida comprobando que est�n todas las claves y que sus valores son correctos
	 * 
	 * @return (true/false)
	 */
	
	private boolean leerProperties(){
		
		Properties prop = new Properties();
		String clave;

		try{
			// Cargamos el fichero de propiedades en el Bean
			prop.load(new FileInputStream(FICH_PROPERTIES));
			
			vt050013Bean.setFicheroOrigen(prop.getProperty("ficheroOrigen"));
			vt050013Bean.setDirDestino(prop.getProperty("dirDestino"));
			//clave=prop.getProperty("ficheroPlano");
			vt050013Bean.setFicheroPlano(prop.getProperty("ficheroPlano").equals("S"));
			vt050013Bean.setFicheroExcel(prop.getProperty("ficheroExcel").equals("S"));
			vt050013Bean.setCaducaMeses(Integer.parseInt(prop.getProperty("caducaMeses")));
			vt050013Bean.setDirBackup(prop.getProperty("dirBackup"));
			vt050013Bean.setEmailTo(prop.getProperty("emailTo"));
			vt050013Bean.setEmailCC(prop.getProperty("emailCC"));
			vt050013Bean.setEmailFrom(prop.getProperty("emailFrom"));
			vt050013Bean.setTxtEmail(prop.getProperty("txtEmail"));
			return true;
		}catch(Exception e){
			log.error(e.getMessage());
			return false;
		}
			
	}

}
