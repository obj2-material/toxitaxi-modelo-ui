package ar.unq.edu.cpi.toxitaxi;

import java.io.Serializable;
import java.time.LocalDate;

public class Viaje implements Serializable {
	private Pasajero quienLoPidio;
	private Direccion origen;
	private Direccion destino;
	private EstadoDeViaje estado;
	private long numero;
	private LocalDate fecha;
	private int tiempoDeDemora;
	private int precio;
	private Chofer chofer;

	public Viaje() { 
		super();
	}
	public Viaje(Pasajero _quienLoPidio, Direccion _origen) {
		super();
		this.quienLoPidio = _quienLoPidio;
		this.origen = _origen;
	}

	public Viaje(Direccion origen, Direccion destino, EstadoDeViaje estado, Chofer chofer) {
		this.origen = origen;
		this.destino = destino;
		this.estado = estado;
		this.chofer = chofer;
	}
	public Pasajero getQuienLoPidio() { return this.quienLoPidio; }
	public void setQuienLoPidio(Pasajero _quienLoPidio) {
		this.quienLoPidio = _quienLoPidio;
	}
	public long getNumero() { return this.numero; }
	public void setNumero(long _numero) { this.numero = _numero; }
	public LocalDate getFecha() { return this.fecha; }
	public void setFecha(LocalDate _fecha) { this.fecha = _fecha; }
	public int getTiempoDeDemora() { return this.tiempoDeDemora; }
	public void setTiempoDeDemora(int demora) { this.tiempoDeDemora = demora; }
	public int getPrecio() { return this.precio; }
	public void setPrecio(int _precio) { this.precio = _precio; }
	public Chofer getChofer() { return chofer; }
	public void setChofer(Chofer chofer) { this.chofer = chofer; }

	public Direccion getOrigen() { return this.origen; }
	public void setOrigen(Direccion _origen) { this.origen = _origen; }
	public Direccion getDestino() { return this.destino; }
	public void setDestino(Direccion _destino) { this.destino = _destino; }
	public boolean esReferidoACalle(String nombreDeCalle) {
		return this.getOrigen().estaEnCalle(nombreDeCalle) || 
				this.getDestino().estaEnCalle(nombreDeCalle);
	}
	public boolean esReferidoACalle_largo(String nombreDeCalle) {
		return this.getOrigen().getCalle().equals(nombreDeCalle) || 
				this.getDestino().getCalle().equals(nombreDeCalle);
	}

	
	public EstadoDeViaje getEstado() { return this.estado; }
	public void setEstado(EstadoDeViaje _estado) { this.estado = _estado; }
	public boolean estaPendiente() { return this.getEstado().equals(EstadoDeViaje.PENDIENTE); }
	public boolean estaResuelto() { 
		return this.getEstado().equals(EstadoDeViaje.EN_VIAJE) || 
				this.getEstado().equals(EstadoDeViaje.DESCARTADO); 
	}
	public boolean esDelDia(LocalDate _fecha) { return this.fecha.equals(_fecha); }
	public boolean estaEnViaje() { return this.getEstado().equals(EstadoDeViaje.EN_VIAJE); }
}
