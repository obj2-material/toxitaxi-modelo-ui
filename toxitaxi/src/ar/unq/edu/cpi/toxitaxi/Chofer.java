package ar.unq.edu.cpi.toxitaxi;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chofer implements Serializable {
	private static final long serialVersionUID = -5751233601880595682L;
	
	private String nroTelefono;
	private String nombre;
	
	public Chofer(String nroTelefono, String nombre) {
		this.nroTelefono = nroTelefono;
		this.nombre = nombre;
	}
	
	public String getNroTelefono() { return this.nroTelefono; }
	public void setNroTelefono(String tel) { this.nroTelefono = tel; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; } 
	
	protected Stream<PagoAChofer> getPagosRecibidosStream() {
		return EmpresaDeRemises.unica().getPagosRealizados().stream()
				.filter((pago) -> pago.getChofer().equals(this));
	}
	public List<PagoAChofer> getPagosRecibidos() {
		return this.getPagosRecibidosStream().collect(Collectors.toList());
	}	
	public long getTotalImporteCobrado() {
		return this.getPagosRecibidosStream().mapToLong(pago -> pago.getImporte()).sum();
	}
	public void recibirPago(LocalDate fecha, long importe, Agencia donde) {
		EmpresaDeRemises.unica().agregarPagoAChofer(
				new PagoAChofer(fecha, this, importe, donde)
		);
	}
	
	private Stream<Viaje> getViajesStream() {
		return CallCenter.unico().getViajes().stream().filter(viaje -> this.equals(viaje.getChofer()));
	}
	
	public long getCantidadViajes() { return this.getViajesStream().count(); }
	
	public boolean estaEnViaje() { return this.getViajesStream().anyMatch(viaje -> viaje.estaEnViaje()); }
}
