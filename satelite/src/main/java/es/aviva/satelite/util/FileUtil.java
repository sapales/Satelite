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

import org.apache.log4j.Logger;

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
	 * Método que hace un backup de un fichero en ud directorio, ambos recibidos como parámetros, añadiéndole el Timestamp
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static boolean backupTimeStamp(String fichero, String dirBackup){
		
		// Conformamos el nombre del fichero de Backup
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String ficheroBackup= dirBackup + nombreFichero(fichero) + "_" + formato.format(fecha) + "." + extensionFichero(fichero);
		
		
		try{
			copiarFichero(fichero, ficheroBackup);
			return true;
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
	public static String pathFichero(String pathAndFichero){
		
		String fichero= pathAndFichero.substring(0, pathAndFichero.lastIndexOf('/')+1);
		
		return fichero;
		
	}
	
	/**
	 * Método que devuelve el nombre de un fichero sin extensión
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static String nombreFichero(String pathAndFichero){
		
		String fichero= pathAndFichero.substring(pathAndFichero.lastIndexOf('/')+1, pathAndFichero.lastIndexOf('.'));
		
		return fichero;
		
	}

	/**
	 * Método que devuelve la extensión de un fichero
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static String extensionFichero(String pathAndFichero){
		
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

}
