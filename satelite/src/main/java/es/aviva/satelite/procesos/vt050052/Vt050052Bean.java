package es.aviva.satelite.procesos.vt050052;

public class Vt050052Bean {
	
	private String ficheroOrigen;
	private String dirDestino;
	private boolean ficheroPlano;
	private boolean ficheroExcel;
	private boolean activo;
	private int caducaMeses;
	private String dirBackup;
	private String emailTo;
	private String emailCC;
	private String emailFrom;
	private String txtEmail;
	private String baseDeDatos;
	
	public String getBaseDeDatos() {
		return baseDeDatos;
	}
	public void setBaseDeDatos(String baseDeDatos) {
		this.baseDeDatos = baseDeDatos;
	}
	public String getFicheroOrigen() {
		return ficheroOrigen;
	}
	public void setFicheroOrigen(String ficheroOrigen) {
		this.ficheroOrigen = ficheroOrigen;
	}
	public String getDirDestino() {
		return dirDestino;
	}
	public void setDirDestino(String dirDestino) {
		this.dirDestino = dirDestino;
	}
	public boolean isFicheroPlano() {
		return ficheroPlano;
	}
	public void setFicheroPlano(boolean ficheroPlano) {
		this.ficheroPlano = ficheroPlano;
	}
	public boolean isFicheroExcel() {
		return ficheroExcel;
	}
	public void setFicheroExcel(boolean ficheroExcel) {
		this.ficheroExcel = ficheroExcel;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public int getCaducaMeses() {
		return caducaMeses;
	}
	public void setCaducaMeses(int caducaMeses) {
		this.caducaMeses = caducaMeses;
	}
	public String getDirBackup() {
		return dirBackup;
	}
	public void setDirBackup(String dirBackup) {
		this.dirBackup = dirBackup;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getEmailCC() {
		return emailCC;
	}
	public void setEmailCC(String emailCC) {
		this.emailCC = emailCC;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getTxtEmail() {
		return txtEmail;
	}
	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}

}
