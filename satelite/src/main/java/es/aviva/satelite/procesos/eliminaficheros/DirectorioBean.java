/**
 * @author   Santiago Pastor Llord
 * @version  1.0.0
 * @date     12/10/2013
 * 
 */

package es.aviva.satelite.procesos.eliminaficheros;

public class DirectorioBean {
	
	String Directorio = "";
	String Patron = "";
	String CadIntervalo = "";
	int CadValor = 0;
	
	/**
	 * @return directorio
	 */
	public String getDirectorio() {
		return Directorio;
	}
	public void setDirectorio(String sDirectorio) {
		this.Directorio = sDirectorio;
	}
	public String getPatron() {
		return Patron;
	}
	public void setPatron(String sPatron) {
		this.Patron = sPatron;
	}
	public String getCadIntervalo() {
		return CadIntervalo;
	}
	public void setCadIntervalo(String sCadIntervalo) {
		this.CadIntervalo = sCadIntervalo;
	}
	public int getCadValor() {
		return CadValor;
	}
	public void setiCadValor(int iCadValor) {
		this.CadValor = iCadValor;
	}

}
