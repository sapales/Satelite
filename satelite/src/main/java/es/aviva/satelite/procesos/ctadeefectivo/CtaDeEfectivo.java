package es.aviva.satelite.procesos.ctadeefectivo;

import java.io.FileInputStream;
import java.io.File;
import java.sql.Connection;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.aviva.satelite.procesos.vt050052.Vt050052;
import es.aviva.satelite.procesos.vt050052.Vt050052Bean;
import es.aviva.satelite.util.ConexionSQLite;
import es.aviva.satelite.util.DateUtil;

/**
* Esta clase localiza los ficheros de cuenta de efectivo
* @author: Santiago Pastor Llord
* @version: 22/09/2016/A
*/

public class CtaDeEfectivo {

	private static final Logger log = Logger.getLogger(CtaDeEfectivo.class.getPackage().getName());
	private static final String FICH_PROPERTIES = "conf/ctadeefectivo.properties";
	private static final String FICH_BD = "db/CtaDeEfectivo.sqlite";
	private CtaDeEfectivoBean ctaDeEfectivoBean = new CtaDeEfectivoBean();
	private int minPeriodo;
	private int maxPeriodo;
	private Connection conn;

	public boolean procesar(){
	
		// Leemos el fichero properties
	    if(!leerProperties()) {
	    	log.error("Error leyendo el fichero de configuración.");
	    	return false;
	    }
	    
		// Comprobamos si está activado el proceso
	    log.info("Comprobamos si está activo el proceso...");
		if(!ctaDeEfectivoBean.isActivo()){
			log.info("Proceso desactivado en fichero properties.");
			return true;
		}
		
		// Comprobamos si hay que ejecutar el proceso por ser la fecha de úlima ejecución menor que la de hoy.
		// Esto es porque este proceso puede durar mucho y no tiene sentido ejecutarlo más de una vez al día.
		log.info("Comprobamos si hay que ejecutar el proceso hoy o si ya se ha ejecutado...");
		if(DateUtil.hayQueEjecutarHoy(ctaDeEfectivoBean.getUltEjecucion())){
	    	log.info("Este proceso no hay que ejecutarlo hoy por haber sido ya ejecutado.");
	    	return false;		
		}
		
		// Abrimos la base de datos
		conn=ConexionSQLite.getConexion(FICH_BD);
		if(conn==null){
	    	log.error("No se ha podido conectar con la BBDD.");
	    	return false;	
		}
		
/*		// Almacenamos los ficheros de Detalle en la BBDD
		if(!CargaFicherosDetalleBD()){
	    	log.error("No se ha podido conectar con la BBDD.");
	    	return false;	
		}
		
		// Almacenamos los ficheros de Justificantes de Pago en la BBDD
		if(!CargaFicherosJustificantesPagoBD()){
	    	log.error("No se ha podido conectar con la BBDD.");
	    	return false;	
		}*/
		
		
		
/*			
		// Comprobamos si hay ficheros nuevos
		log.info("Buscando ficheros nuevos...");
		File directorio = new File(ctaDeEfectivoBean.getDirOrigen());
		
		// Si es un directorio
		if (!directorio.isDirectory()) {
			log.error("El directorio origen indicado (" + ctaDeEfectivoBean.getDirOrigen() + "' no es correcto.");
			return false;
		}
			
		// obtenemos su contenido
		File[] ficheros = directorio.listFiles();
		
		// y lo sacamos por pantalla
		for (File fichero : ficheros)
			System.out.println(fichero.getName());*/
		
		
		// Borramos los "caducados"
		
		
		// Generamos el fichero de Cuenta de Efectivo
		
		
		// Lo subimos a la web
		
		
		// Generamos el fichero de Pagos de Cuenta de Efectivo
		
		
		// Lo subimos a la web
		
		
		// Grabamos la fecha de última ejecución
		
		return true;
		
	}

	/**
	 * Método para leer el fichero de propiedades (.properties) del proceso CtaDeEfectivo. 
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
			
			ctaDeEfectivoBean.setActivo(prop.getProperty("activo").equals("S"));
			ctaDeEfectivoBean.setUltEjecucion(prop.getProperty("ultimaEjecucion"));
			ctaDeEfectivoBean.setDirOrigenDCE(prop.getProperty("directorioOrigenDCE"));
			ctaDeEfectivoBean.setCaducaMesesDCE(Integer.parseInt(prop.getProperty("caducaMesesDCE")));
			ctaDeEfectivoBean.setDirOrigenJP(prop.getProperty("directorioOrigenJP"));
			ctaDeEfectivoBean.setCaducaMesesJP(Integer.parseInt(prop.getProperty("caducaMesesJP")));
			return true;
		}catch(Exception e){
			log.error(e.getMessage());
			return false;
		}

	}
	
}
