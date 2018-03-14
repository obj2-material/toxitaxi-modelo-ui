package ar.unq.edu.cpi.toxitaxi;

import java.time.LocalDate;

public class DatosAgregados {
	
	public DatosAgregados() { super(); }

	private CallCenter callCenter() { return CallCenter.unico(); }
	
	/**
	 * Para que cada uno agregue los pasajeros que quiera.
	 * Dejo uno comentado para ejemplo.
	 */
	public void agregarPasajerosAdicionales() { 
//		Pasajero pepeCurdeles = new Pasajero("Pepe Curdeles", "011-5493-3942"); 
//		pasajeroActual.setDireccionPrincipal(new Direccion("Bermúdez", "1803"));
//		this.agregarPasajero(pasajeroActual);
	}

	/**
	 * Para que cada uno agregue los choferes que quiera.
	 * Dejo uno comentado para ejemplo.
	 */
	public void agregarChoferesAdicionales() { 
//		this.agregarChofer(new Chofer("043-339-2932", "Julián Pérez"));
	}

	/**
	 * Para que cada uno agregue logs viajes que quiera. Dejo uno como ejemplo.
	 */
	public void agregarViajesAdicionales() { 
		Pasajero ricky = this.getPasajeroConNombre("Ricky Maravilla");
		Chofer mariela = this.getChoferConNombre("Mariela");
		Direccion congreso = new Direccion("Callao", "52");
		
		Viaje nuevoViaje = new Viaje(ricky, congreso);
		this.seRecibioPedido(nuevoViaje);
		this.seAsignoViaje(nuevoViaje, mariela, 7);
	}
	
	/**
	 * Para que cada uno agregue las agencias que quiera. Dejo una comentada como ejemplo.
	 */
	public void agregarAgenciasAdicionales() {
//		this.agregarAgencia(new Agencia(new Direccion("Perón", "2743"), "Once", 2011));
	}	
	
	/**
	 * Para que cada uno agregue los pagos a chofer que quiera. Dejo uno comentado como ejemplo.
	 */
	public void cargarPagosAChoferAdicionales() {
//		Chofer josefa = this.getChoferConNombre("Josefa");
//		Agencia centro = this.getAgenciaConNombre("Centro");
//	
//		josefa.recibirPago(LocalDate.of(2018, 3, 12), 4400, centro);
	}

	
	
	/*
	 * Estos son métodos para facilitar el agregado de cosas.
	 * Evitan tener que hacer referencia al CallCenter o a la EmpresaDeRemises todo el tiempo.
	 */
	public void agregarPasajero(Pasajero nuevoPasajero) {
		this.callCenter().agregarPasajero(nuevoPasajero);
	}

	public Pasajero getPasajeroConNombre(String nombrePas) {
		return this.callCenter().getPasajeroConNombre(nombrePas);
	}

	public void agregarChofer(Chofer nuevoChofer) {
		this.callCenter().agregarChofer(nuevoChofer);
	}

	public Chofer getChoferConNombre(String nombreCho) {
		return this.callCenter().getChoferConNombre(nombreCho);
	}

	public void seRecibioPedido(Viaje viaje) {
		this.callCenter().seRecibioPedido(viaje);
	}

	public void seAsignoViaje(Viaje viaje, Chofer chofer, int demora) {
		this.callCenter().seAsignoViaje(viaje, chofer, demora);
	}

	public void seDescartoViaje(Viaje viaje) {
		this.callCenter().seDescartoViaje(viaje);
	}

	public void seTerminoViaje(Viaje viaje, Direccion destino, int precio) {
		this.callCenter().seTerminoViaje(viaje, destino, precio);
	}
	
	public void agregarAgencia(Agencia nuevaAgencia) {
		EmpresaDeRemises.unica().agregarAgencia(nuevaAgencia);
	}
	
	private Agencia getAgenciaConNombre(String nombre) {
		return EmpresaDeRemises.unica().getAgenciaConNombre(nombre);
	}

	
}
