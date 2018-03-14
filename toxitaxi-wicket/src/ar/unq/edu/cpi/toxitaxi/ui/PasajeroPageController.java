package ar.unq.edu.cpi.toxitaxi.ui;

import java.io.Serializable;

import ar.unq.edu.cpi.toxitaxi.Pasajero;

public class PasajeroPageController implements Serializable {
	private static final long serialVersionUID = -4731200673587405651L;
	
	private Pasajero pasajero;
	
	public PasajeroPageController(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
}
