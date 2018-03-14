package ar.unq.edu.cpi.toxitaxi;

import java.io.Serializable;

public class Pasajero implements Serializable {
	private static final long serialVersionUID = 4222550198534695411L;

	private String nomApe;
	private String nroTelefono;
	private Direccion direccionPrincipal;
	
	public Pasajero(String _nomApe, String _nroTelefono) {
		super();
		this.nomApe = _nomApe;
		this.nroTelefono = _nroTelefono;
	}
	
	public String getNomApe() { return this.nomApe; }
	public String getNroTelefono() { return this.nroTelefono; }
	public Direccion getDireccionPrincipal() { return this.direccionPrincipal; }
	
	public void setDireccionPrincipal(Direccion dir) {
		this.direccionPrincipal = dir;
	}
	
}
