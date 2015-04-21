package es.aviva.satelite.test;

import java.util.ArrayList;
import java.util.Iterator;

import es.aviva.satelite.util.FiltrarDir;

public class TestFiltrarDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<String> filtrados = new ArrayList<String>();
		
		System.out.println("==== *.pdf ====");
		filtrados = FiltrarDir.filtrar("D:/test/pdf", "*.pdf");
		Iterator f=filtrados.iterator();
		while(f.hasNext()){
			System.out.println(f.next());
		}
		
		System.out.println("==== *.txt ====");
		filtrados = FiltrarDir.filtrar("D:/test/pdf", "*.txt");
		f=filtrados.iterator();
		while(f.hasNext()){
			System.out.println(f.next());
		}
		
		System.out.println("==== j*.txt ====");
		filtrados = FiltrarDir.filtrar("D:/test/pdf", "j*.pdf");
		f=filtrados.iterator();
		while(f.hasNext()){
			System.out.println(f.next());
		}
		
		
		System.out.println("==== *.pdf ====");
		filtrados = FiltrarDir.filtrarIgnorarCase("D:/test/pdf", "*.pdf");
		f=filtrados.iterator();
		while(f.hasNext()){
			System.out.println(f.next());
		}
		
		System.out.println("==== *.txt ====");
		filtrados = FiltrarDir.filtrarIgnorarCase("D:/test/pdf", "*.txt");
		f=filtrados.iterator();
		while(f.hasNext()){
			System.out.println(f.next());
		}
		
		System.out.println("==== j*.txt ====");
		filtrados = FiltrarDir.filtrarIgnorarCase("D:/test/pdf", "j*.pdf");
		f=filtrados.iterator();
		while(f.hasNext()){
			System.out.println(f.next());
		}

	}

}
