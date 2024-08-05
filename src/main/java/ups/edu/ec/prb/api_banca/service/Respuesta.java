package ups.edu.ec.prb.api_banca.service;

public class Respuesta {
	
	private int codigo;
	private String mensaje;
	
	public static int OK = 1;
	public static int ERROR = 99;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public static int getOK() {
		return OK;
	}
	public static void setOK(int oK) {
		OK = oK;
	}
	public static int getERROR() {
		return ERROR;
	}
	public static void setERROR(int eRROR) {
		ERROR = eRROR;
	}
	
	
	public Respuesta(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	
	
	
	

}
