package es.aviva.satelite.util;

import java.io.File;
import java.util.ArrayList;

public class FiltrarDir {

	public static void FiltrarDir(){
		
	}
	
	public static ArrayList<String> filtrarIgnorarCase(String directorio, String patron){
		
		ArrayList<String> retorno = new ArrayList<String>();
		String filtroNombre     = "";
		String filtroExtension  = "";
		String caracteres       = "";
		String ficheroNombre    = "";
		String ficheroExtension = "";
		String nombreReal       = "";
		
		// TODO Santi. Hasta que revise este método, pongo el patrón en mayúsculas y cada vez que
		// recupero un fichero, también lo paso a mayúsculas
		patron = patron.toUpperCase();
		
		// Separamos Nombre y Extensión del patrón
		int idx = patron.lastIndexOf('.');
		if (idx > -1) {
			filtroExtension = patron.substring(idx+1);
			filtroNombre = patron.substring(0,idx);
		} else {
			filtroNombre=patron;
		}
		
		// Obtenemos el directorio
		File dir = new File(directorio);
		
		// Obtenemos los ficheros del directorio
		String[] ficheros = dir.list();
		
		// Filtramos
		for(int i=0;i<ficheros.length;i++){
			
			// Guardamos el nombre real del fichero
			nombreReal=ficheros[i];
			// Ponemos en mayúsculas el nombre del fichero para comparar
			ficheros[i]=ficheros[i].toUpperCase();
			// Separamos Nombre y Extensión del fichero
			idx = ficheros[i].lastIndexOf('.');
			if (idx > -1) {
				ficheroExtension = ficheros[i].substring(idx+1);
				ficheroNombre = ficheros[i].substring(0,idx);
			} else {
				ficheroNombre=ficheros[i];
			}
			
			// Filtramos el nombre
			if(filtroNombre.equals("*")){
				// No filtramos el nombre
			}else if(filtroNombre.startsWith("*") && filtroNombre.endsWith("*")){
				// Cogemos los caracteres intermedios
				caracteres=filtroNombre.substring(1,filtroNombre.length()-2);
				if(ficheroNombre.substring(1, ficheroNombre.length()-2).contains(caracteres)){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			} else if(filtroNombre.startsWith("*")){
				// Cogemos los caracteres finales
				caracteres=filtroNombre.substring(1,filtroNombre.length());
				if(ficheroNombre.endsWith((caracteres))){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}				
			} else if(filtroNombre.endsWith("*")){
				// Cogemos los caracteres finales
				caracteres=filtroNombre.substring(0,filtroNombre.length()-1);
				if(ficheroNombre.startsWith((caracteres))){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			} else {
				// No hay asteriscos
				if(ficheroNombre.startsWith(filtroNombre)){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			}
			// Filtramos la extensión 
			if(filtroExtension.equals("*")){
				// No filtramos la extensión
			}else if(filtroExtension.startsWith("*") && filtroExtension.endsWith("*")){
				// Cogemos los caracteres intermedios
				caracteres=filtroExtension.substring(1,filtroExtension.length()-2);
				if(ficheroExtension.substring(1, ficheroExtension.length()-2).contains(caracteres)){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			} else if(filtroExtension.startsWith("*")){
				// Cogemos los caracteres iniciales
				caracteres=filtroExtension.substring(2,filtroExtension.length()-1);
				if(ficheroExtension.startsWith((caracteres))){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}				
			} else if(filtroExtension.endsWith("*")){
				// Cogemos los caracteres finales
				caracteres=filtroExtension.substring(1,filtroExtension.length());
				if(ficheroExtension.endsWith((caracteres))){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			} else {
				// No hay asteriscos
				if(ficheroExtension.endsWith(filtroExtension)){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			}
			
			if(!ficheros[i].equals(""))
				retorno.add(nombreReal);
		}  
		
		return retorno;
			
	}
	
	public static ArrayList<String> filtrar(String directorio, String patron){
		
		ArrayList<String> retorno = new ArrayList<String>();
		String filtroNombre     = "";
		String filtroExtension  = "";
		String caracteres       = "";
		String ficheroNombre    = "";
		String ficheroExtension = "";
		
		// Separamos Nombre y Extensión del patrón
		int idx = patron.lastIndexOf('.');
		if (idx > -1) {
			filtroExtension = patron.substring(idx+1);
			filtroNombre = patron.substring(0,idx);
		} else {
			filtroNombre=patron;
		}
		
		// Obtenemos el directorio
		File dir = new File(directorio);
		
		// Obtenemos los ficheros del directorio
		String[] ficheros = dir.list();
		
		// Filtramos
		for(int i=0;i<ficheros.length;i++){
			
			// Separamos Nombre y Extensión del fichero
			idx = ficheros[i].lastIndexOf('.');
			if (idx > -1) {
				ficheroExtension = ficheros[i].substring(idx+1);
				ficheroNombre = ficheros[i].substring(0,idx);
			} else {
				ficheroNombre=ficheros[i];
			}
			
			// Filtramos el nombre
			if(filtroNombre.equals("*")){
				// No filtramos el nombre
			}else if(filtroNombre.startsWith("*") && filtroNombre.endsWith("*")){
				// Cogemos los caracteres intermedios
				caracteres=filtroNombre.substring(1,filtroNombre.length()-2);
				if(ficheroNombre.substring(1, ficheroNombre.length()-2).contains(caracteres)){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			} else if(filtroNombre.startsWith("*")){
				// Cogemos los caracteres finales
				caracteres=filtroNombre.substring(1,filtroNombre.length());
				if(ficheroNombre.endsWith((caracteres))){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}				
			} else if(filtroNombre.endsWith("*")){
				// Cogemos los caracteres finales
				caracteres=filtroNombre.substring(0,filtroNombre.length()-1);
				if(ficheroNombre.startsWith((caracteres))){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			} else {
				// No hay asteriscos
				if(ficheroNombre.startsWith(filtroNombre)){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			}
			// Filtramos la extensi�n 
			if(filtroExtension.equals("*")){
				// No filtramos la extensi�n
			}else if(filtroExtension.startsWith("*") && filtroExtension.endsWith("*")){
				// Cogemos los caracteres intermedios
				caracteres=filtroExtension.substring(1,filtroExtension.length()-2);
				if(ficheroExtension.substring(1, ficheroExtension.length()-2).contains(caracteres)){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			} else if(filtroExtension.startsWith("*")){
				// Cogemos los caracteres iniciales
				caracteres=filtroExtension.substring(2,filtroExtension.length()-1);
				if(ficheroExtension.startsWith((caracteres))){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}				
			} else if(filtroExtension.endsWith("*")){
				// Cogemos los caracteres finales
				caracteres=filtroExtension.substring(1,filtroExtension.length());
				if(ficheroExtension.endsWith((caracteres))){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			} else {
				// No hay asteriscos
				if(ficheroExtension.endsWith(filtroExtension)){
					// Es correcto. No hacemos nada
				} else {
					ficheros[i] = "";
				}
			}
			
			if(!ficheros[i].equals(""))
				retorno.add(ficheros[i]);
		}  
		
		return retorno;
	}
	
}
