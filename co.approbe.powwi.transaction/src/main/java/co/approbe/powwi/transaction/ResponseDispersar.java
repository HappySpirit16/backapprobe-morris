package co.approbe.powwi.transaction;

public class ResponseDispersar {
	private  String codigoResultado="TBA_400";
	private String mensaje="FAIL";
	public ResponseDispersar(String codigoResultado, String mensaje) {
		super();
		this.codigoResultado = codigoResultado;
		this.mensaje = mensaje;
	}
	public ResponseDispersar() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "{\"codigoResultado\":\"" + codigoResultado + "\", \"mensaje\":\"" + mensaje + "\"}";
	}
	

}
