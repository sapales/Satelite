package es.aviva.satelite.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtil {

	private static final Logger log = Logger.getLogger(DateUtil.class.getPackage().getName());
	
	/**
	 * Método que comprueba si la fecha recibida como parámetro es menor que la de hoy
	 * @author Santiago Pastor
	 * @version 1.0.0
	 */
	public static boolean hayQueEjecutarHoy(String ultEjecucion){
		
		
		// Transformamos la fecha recibida como parámetro en Date
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = formatoDelTexto.parse(ultEjecucion);
		}catch (Exception ex){
			log.error(ex.getMessage());
			return false;
		}
		
		// Cogemos la fecha de hoy
		try{
			Calendar tmp = Calendar.getInstance();
			tmp.set(Calendar.HOUR_OF_DAY, 0);
			tmp.set(Calendar.MINUTE, 0);
			tmp.set(Calendar.SECOND, 0);
	        tmp.set(Calendar.MILLISECOND, 0);

	        Date hoy = tmp.getTime();
        
			if(fecha.before(hoy))
				return true;
			else
				return false;

		}catch(Exception e){
			log.error(e.getMessage());
			return false;
		}
		
	}

}
