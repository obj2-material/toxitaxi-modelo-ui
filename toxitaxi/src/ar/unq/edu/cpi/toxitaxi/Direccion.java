package ar.unq.edu.cpi.toxitaxi;

import java.io.Serializable;

public class Direccion implements Serializable {
	private String calle;
	private String numero;
	
	public Direccion(String _calle, String _numero) {
		super();
		this.calle = _calle;
		this.numero = _numero;		
	}
	
	public String getCalle() { return this.calle; }
	public void setCalle(String _calle) { this.calle = _calle; }
	public String getNumero() { return this.numero; }
	public void setNumero(String _numero) { this.numero = _numero; }
	
	public boolean estaEnCalle(String calleCandidata) {
		return this.getCalle().toUpperCase().equals(calleCandidata.toUpperCase());
	}
	
	public String completa() {
		return getCalle() + " " + getNumero();
	}
}
