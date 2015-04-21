/**
 * Clase: Satelite
 * Esta es la clase principal (main()) de la aplicación.
 * @author: Santiago Pastor
 * @version: 1.0
 * 
 */
package es.aviva.satelite;

import es.aviva.satelite.procesos.eliminaficheros.EliminaFicheros;
import es.aviva.satelite.procesos.vt050013.*;

public class Satelite {

	/**
	 * Este es el método principal (main()) de entrada a la aplicación.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Ejecutamos el proceso de eliminación de ficheros
		EliminaFicheros ef = new EliminaFicheros();
		ef.procesar();
		
		// Ejecutamos el tratamiento del fichero VT050013
		Vt050013 vt050013 = new Vt050013();
		vt050013.procesar();
	}

}