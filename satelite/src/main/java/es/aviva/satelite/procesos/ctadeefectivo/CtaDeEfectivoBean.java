package es.aviva.satelite.procesos.ctadeefectivo;

public class CtaDeEfectivoBean {

	private boolean activo;
	private String dirOrigenDCE;
	private int caducaMesesDCE;
	private String dirOrigenJP;
	private int caducaMesesJP;
	private String ultEjecucion;

	/*	private String emailTo;
	private String emailCC;
	private String emailFrom;
	private String txtEmail;
*/
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String getUltEjecucion() {
		return ultEjecucion;
	}
	
	public void setUltEjecucion(String ultEjecucion) {
		this.ultEjecucion = ultEjecucion;
	}

	public String getDirOrigenDCE() {
		return dirOrigenDCE;
	}
	
	public void setDirOrigenDCE(String dirOrigen) {
		this.dirOrigenDCE = dirOrigen;
	}
	public int getCaducaMesesDCE() {
		return caducaMesesDCE;
	}
	public void setCaducaMesesDCE(int caducaMeses) {
		this.caducaMesesDCE = caducaMeses;
	}

	public String getDirOrigenJP() {
		return dirOrigenJP;
	}
	public void setDirOrigenJP(String dirOrigenJP) {
		this.dirOrigenJP = dirOrigenJP;
	}

	public int getCaducaMesesJP() {
		return caducaMesesJP;
	}

	public void setCaducaMesesJP(int caducaMesesJP) {
		this.caducaMesesJP = caducaMesesJP;
	}
	
	
}
