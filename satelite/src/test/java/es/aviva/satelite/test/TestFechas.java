package es.aviva.satelite.test;

import java.util.Calendar;
import java.util.Date;

public class TestFechas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		Date fecha = new Date();
		fecha = cal.getTime();
		
		System.out.println(fecha);
		
		System.out.println(String.format("%tr",fecha));
		System.out.println(String.format("%tH",fecha));
		System.out.println(String.format("%tM",fecha));
		System.out.println(String.format("%tS",fecha));
		System.out.println(String.format("%tH:%tM:%tS",fecha,fecha,fecha));
	}

}
