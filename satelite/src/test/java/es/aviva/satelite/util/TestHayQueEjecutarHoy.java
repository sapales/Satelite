package es.aviva.satelite.util;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TestHayQueEjecutarHoy {

	public static void main (String[] args){
		
		String fecha1="12/12/2013";
		String fecha2="12/12/2099";
		
		Date hoy = new Date();
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		String fecha3 = form.format(hoy);
		
		System.out.println(DateUtil.hayQueEjecutarHoy(fecha1));
		System.out.println(DateUtil.hayQueEjecutarHoy(fecha2));
		System.out.println(DateUtil.hayQueEjecutarHoy(fecha3));
	}

}
