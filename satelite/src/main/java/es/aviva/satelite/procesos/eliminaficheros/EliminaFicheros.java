package es.aviva.satelite.procesos.eliminaficheros;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

import es.aviva.satelite.util.FiltrarDir;

public class EliminaFicheros {

	//static final String FICH_PROPERTIES = "/es/aviva/satelite/clases/procesos/eliminaficheros/eliminaficheros.properties";
	static final String FICH_PROPERTIES = "conf/eliminaficheros.properties";
	
	/**
	 * @param args
	 */
	public boolean procesar() {
		
		int ndirectorio=-1;
		
		System.out.println(System.getProperty("user.dir"));
		
		// Leemos el fichero .properties
		PropiedadesBean pb = new PropiedadesBean(FICH_PROPERTIES);
		
		//
		Iterator directorios = pb.directorios.iterator();
		
		while(directorios.hasNext()){
			// Operamos sobre cada directorio
			ndirectorio++;
			System.out.println("------Elemento del arreglo: " + directorios.next()); 	
			DirectorioBean db= new DirectorioBean();
			db = (DirectorioBean) pb.directorios.get(ndirectorio);
			System.out.println(db.getDirectorio());
			ArrayList<String> filtrados = new ArrayList<String>();
			filtrados = FiltrarDir.filtrar(db.getDirectorio(), db.Patron);
			Iterator f=filtrados.iterator();
			while(f.hasNext()){
				System.out.println(f.next());
			}
		}
		
		return true;
	}
	
}
	
