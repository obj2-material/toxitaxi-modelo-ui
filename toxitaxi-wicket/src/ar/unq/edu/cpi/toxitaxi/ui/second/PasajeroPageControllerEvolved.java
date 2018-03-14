package ar.unq.edu.cpi.toxitaxi.ui.second;

import java.io.Serializable;
import java.util.List;

import ar.unq.edu.cpi.toxitaxi.CallCenter;
import ar.unq.edu.cpi.toxitaxi.Chofer;
import ar.unq.edu.cpi.toxitaxi.Pasajero;
import ar.unq.edu.cpi.toxitaxi.Viaje;

public class PasajeroPageControllerEvolved implements Serializable {
	private static final long serialVersionUID = -4731200673587405651L;
	
	private Pasajero pasajero;
	private Chofer chofer;
	
	public PasajeroPageControllerEvolved(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	public Pasajero getPasajero() { return pasajero; }
	public void setPasajero(Pasajero pasajero) { this.pasajero = pasajero; }
	
	public Chofer getChofer() { return this.chofer; }
	public void setChofer(Chofer elChofer) { this.chofer = elChofer; }
	
	public List<Viaje> getViajes() { return CallCenter.unico().getViajesDe(this.pasajero); }
}
