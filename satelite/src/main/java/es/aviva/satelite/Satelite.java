/**
 * Clase: Satelite
 * Esta es la clase principal (main()) de la aplicación.
 * @author: Santiago Pastor
 * @version: 1.0
 * 
 */
package es.aviva.satelite;

import org.apache.log4j.Logger;

import es.aviva.satelite.procesos.eliminaficheros.EliminaFicheros;
import es.aviva.satelite.procesos.vt050013.*;
import es.aviva.satelite.procesos.vt050052.*;

public class Satelite {

	/**
	 * Este es el método principal (main()) de entrada a la aplicación.
	 * @param args
	 */
	private static final Logger log = Logger.getLogger(Satelite.class.getPackage().getName());
	
	public static void main(String[] args) {
		
		log.info("Iniciando ejecución...");
		
		// Ejecutamos el proceso de eliminación de ficheros
		log.info("Ejecutamos el proceso de eliminación de ficheros...");
/*		EliminaFicheros ef = new EliminaFicheros();
		if(!ef.procesar())
			log.error("Error ejecutando el proceso de eliminación de ficheros...");
*/		
		// Ejecutamos el tratamiento del fichero VT050013
/*		log.info("Ejecutamos el tratamiento del fichero VT050013...");
		Vt050013 vt050013 = new Vt050013();
		if(!vt050013.procesar())
			log.error("Error ejecutando el tratamiento del fichero VT050013...");*/

		// Ejecutamos el tratamiento del fichero VT050052
		log.info("Ejecutamos el tratamiento del fichero VT050052...");
		Vt050052 vt050052 = new Vt050052();
		if(!vt050052.procesar())
			log.error("Error ejecutando el tratamiento del fichero VT050052...");
	
		log.info("Fin de la ejecución.");
		
	}

}