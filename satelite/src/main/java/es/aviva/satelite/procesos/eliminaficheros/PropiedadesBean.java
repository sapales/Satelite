/**
 * Clase para la lectura del fichero de propiedades (.properties) del proceso "EliminaFicheros"
 * @author   Santiago Pastor Llord
 * @version  1.0.0
 * @date     12/10/2013
 * 
 */

package es.aviva.satelite.procesos.eliminaficheros;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class PropiedadesBean {

	ArrayList directorios = new ArrayList();
	String sDirectorio   = "";
	String sPatron       = "";
	String sCadIntervalo = ""; 
	String sClave        = "";
	String sPropiedad        = "";
	int iClave = 0;
	int iCadValor  = 0;
	
	public PropiedadesBean(String fichPropiedades){
		
		Properties prop = new Properties();

		try{
			// Cargamos el fichero de propiedades en el Bean
			prop.load(new FileInputStream(fichPropiedades));
			
			// Recorremos el fichero cargando las propiedades en Beans
			while(true){
				iClave++;
				// Leemos el directorio
				sClave = "directorio" + Integer.toString(iClave) + ".dir";
				sPropiedad=prop.getProperty(sClave);
		        if(sPropiedad==null){
		        	break;
		        }
		        sDirectorio=sPropiedad;
		        int n = sDirectorio.length();

				// Leemos el patrón
				sClave = "directorio" + Integer.toString(iClave) + ".patron";
				sPropiedad=prop.getProperty(sClave);
		        if(sPropiedad==null){
		        	break;
		        }
		        sPatron=sPropiedad;
		        
				// Leemos el intervalo
				sClave = "directorio" + Integer.toString(iClave) + ".caducidad.intervalo";
				sPropiedad=prop.getProperty(sClave);
		        if(sPropiedad==null){
		        	break;
		        }
		        sCadIntervalo=sPropiedad;
				// Leemos el valor del intervalo
				sClave = "directorio" + Integer.toString(iClave) + ".caducidad.valor";
				sPropiedad=prop.getProperty(sClave);
		        if(sPropiedad==null){
		        	break;
		        }
		        iCadValor=Integer.parseInt(sPropiedad);
		        
		        DirectorioBean db= new DirectorioBean();
		        db.setDirectorio(sDirectorio);
		        db.setPatron(sPatron);
		        db.setCadIntervalo(sCadIntervalo);
		        db.setiCadValor(iCadValor);
		        
		        directorios.add(db);
		        
		        db=null;
			
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
