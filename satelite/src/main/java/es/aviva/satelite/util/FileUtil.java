package es.aviva.satelite.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import java.util.LinkedList;
import java.util.regex.Pattern;
/**
 * Clase para utilidades de ficheros
 * @author Santiago Pastor
 * @version 1.0.0
 */

public class FileUtil {
	
	private static final Logger log = Logger.getLogger(FileUtil.class.getPackage().getName());
	
	/**
	 * Método que comprueba si existe un fichero recibido como parámetro
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static boolean existeFichero(String fichero){
		
		try{
			File f = new File(fichero);
			return f.exists();
		}
		catch (Exception e){
			log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Método que devuelve los ficheros que coincidan con un determinado patrón recibido como parámetro
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	/* Santi: Este método está esbozado tomando como modelo:
	 * http://chuwiki.chuidiang.org/index.php?title=B%C3%BAsqueda_de_ficheros
	 * Hay que adaptarlo y terminarlo. Lo comento mientras tanto
	 */
/*	public static ArrayList<String> dameFicherosByPatron(String directorio, String ficheroConPatron){
		
		ArrayList<String> ficherosByPatron =  new ArrayList<String>(); 
		
		try{
			File[] ficheros = directorio.listFiles();
			for (int i = 0; i < ficheros.length; i++)
			{
				if(ficheros[i]="patron")
				{
					ficherosByPatron.add(ficheros[i].getName());
				}
			return ficherosByPatron;
		}
		catch (Exception e){
			log.error(e.getMessage());
			return false;
		}
	}*/
		
	/**
	 * Método que comprueba si un fichero recibido como parámetro contiene datos o no
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static boolean isEmptyFile(String fichero){
		
		try{
			File f = new File(fichero);
			if(f.length()>0)
				return false;
			else
				return true; 
		}
		catch (Exception e){
			log.error(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Método que hace un backup de un fichero en un directorio, ambos recibidos como parámetros, añadiéndole el Timestamp
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static boolean backupTimeStamp(String fichero, String dirBackup){
		
		// Conformamos el nombre del fichero de Backup
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String ficheroBackup= dirBackup + getNombreFichero(fichero) + "_" + formato.format(fecha) + "." + getExtensionFichero(fichero);
		
		try{
			if(copiarFichero(fichero, ficheroBackup))
				return true;
			else
				return false;
		}
		catch (Exception e){
			log.error(e.getMessage());
			return false;
		}
		
	}
	
	/**
	 * Método que devuelve el path de un fichero
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static String getPathFichero(String pathAndFichero){
		
		String fichero= pathAndFichero.substring(0, pathAndFichero.lastIndexOf('/')+1);
		
		return fichero;
		
	}
	
	/**
	 * Método que devuelve el nombre de un fichero sin extensión ni path
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static String getNombreFichero(String pathAndFichero){
		
		File fichero = new File(pathAndFichero);
		
		// Obtenemos el nombre del fichero y extensión del mismo sin el PATH
		String nombreFichero= fichero.getName();
				
		// Quitamos la extensión
		nombreFichero= nombreFichero.substring(0, nombreFichero.lastIndexOf('.'));
		
		return nombreFichero;
		
	}

	/**
	 * Método que devuelve el nombre de un fichero sin extensión ni path
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static String getNombreExtensionFichero(String pathAndFichero){
		
		File fichero = new File(pathAndFichero);
		
		// Obtenemos el nombre del fichero y extensión del mismo sin el PATH
		String nombreFichero= fichero.getName();
		
		return nombreFichero;
		
	}

	/**
	 * Método que devuelve la extensi�n de un fichero
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static String getExtensionFichero(String pathAndFichero){
		
		String fichero= pathAndFichero.substring(pathAndFichero.lastIndexOf('.')+1);
		
		return fichero;
		
	}

    /**
     * Método que copia todo el contenido de un directorio a otro directorio
     * @param srcDir
     * @param dstDir
     * @throws IOException
     */
    public static boolean copiarDirectorio(File srcDir, File dstDir)
    {
        try{
            if (srcDir.isDirectory()) {
                if (!dstDir.exists()) {
                    dstDir.mkdir();
                }

                String[] children = srcDir.list();
                for (int i=0; i<children.length; i++) { 
                		copiarDirectorio(new File(srcDir, children[i]),
                        new File(dstDir, children[i]));
                }
            } else {
            	copiarFichero(srcDir, dstDir);
            }
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }    
    
    /**
     * Método que copia un archivo de un sitio a otro
     * @param s
     * @param t
     * @throws IOException
     */
    public static boolean copiarFichero(String ficheroOrigen, String ficheroDestino)
    {
        try{
              File in = (new File(ficheroOrigen));
              File out = (new File(ficheroDestino));
              copiarFichero(in,out);
              return true;
        }
        catch(Exception e)
        {
            log.error(e.getMessage());
            return false;
        }
    }
    
    /**
     * Método que copia un archivo de un sitio a otro
     * @param s
     * @param t
     * @throws IOException
     */
    public static boolean copiarFichero(File ficheroOrigen, File ficheroDestino)
    {
        try{
              FileChannel in = (new FileInputStream(ficheroOrigen)).getChannel();
              FileChannel out = (new FileOutputStream(ficheroDestino)).getChannel();
              in.transferTo(0, ficheroOrigen.length(), out);
              in.close();
              out.close();
              return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    /**
     * Método que copia un archivo de un sitio a otro reemplazando un String por otro
     * @param source_file
     * @param destination_file
     * @param toFind
     * @param toReplace
     * @throws IOException
     */
    public void copiarReemplazando(String source_file, String destination_file, String toFind, String toReplace)
    {
        String str;
        try{
            FileInputStream fis2 = new FileInputStream(source_file);
            DataInputStream input = new DataInputStream (fis2);
            FileOutputStream fos2 = new FileOutputStream(destination_file);
            DataOutputStream output = new DataOutputStream (fos2);

            while (null != ((str = input.readLine())))
            {
                String s2=toFind;
                String s3=toReplace;

                int x=0;
                int y=0;
                String result="";
                while ((x=str.indexOf(s2, y))>-1) {
                    result+=str.substring(y,x);
                    result+=s3;
                    y=x+s2.length();
                }
                result+=str.substring(y);
                str=result;

                if(str.indexOf("'',") != -1){
                    continue;
                }
                else{
                    str=str+"\n";
                    output.writeBytes(str);
                }
            }
        }
        catch (IOException ioe)
        {
            System.err.println ("I/O Error - " + ioe);
        }
    }

    /**
     * Busca todos los ficheros que cumplen la máscara que se le pasa y los
     * mete en la listaFicheros que se le pasa.
     * 
     * @param pathInicial Path inicial de búsqueda. Debe ser un directorio que
     * exista y con permisos de lectura.
     * @param mascara Una máscara válida para la clase Pattern de java.
     * @param listaFicheros Una lista de ficheros a la que se añadirán los File
     * que cumplan la máscara. No puede ser null. El método no la vacía.
     * @param busquedaRecursiva Si la búsqueda debe ser recursiva en todos los
     * subdirectorios por debajo del pathInicial.
     */
    public static void dameFicheros(String pathInicial, String mascara,
            LinkedList<File> listaFicheros, boolean busquedaRecursiva)
    {
        File directorioInicial = new File(pathInicial);
        if (directorioInicial.isDirectory())
        {
            File[] ficheros = directorioInicial.listFiles();
            for (int i = 0; i < ficheros.length; i++)
            {
                if (ficheros[i].isDirectory() && busquedaRecursiva)
                    dameFicheros(ficheros[i].getAbsolutePath(), mascara,
                            listaFicheros, busquedaRecursiva);
                else if (Pattern.matches(mascara, ficheros[i].getName()))
                    listaFicheros.add(ficheros[i]);
            }
        }
    }
    
}
