package ar.unq.edu.cpi.toxitaxi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CallCenter {

	private static CallCenter elUnico;
	private DatosAgregados agregados;
	
	public static CallCenter unico() {
		if (elUnico == null) { elUnico = new CallCenter(); }
		return elUnico;
	}
	private CallCenter() { 
		super();
		this.agregados = new DatosAgregados();
	}
	
	private List<Viaje> viajes = new ArrayList<>();
	private Collection<ObservadorToxiTaxi> observadores = new HashSet<>();
	private List<Pasajero> pasajeros = new ArrayList<>();
	private List<Chofer> choferes = new ArrayList<>();

	public List<Viaje> getViajes() { return this.viajes; }
	
	public void cargarDataInicial() {
		this.cargarPasajerosIniciales();		
		this.cargarChoferesIniciales();		
		this.cargarViajesIniciales();
	}
		
	private void cargarPasajerosIniciales() {
		Pasajero pasajeroActual = new Pasajero("Ricky Maravilla", "99-3333-4444"); 
		pasajeroActual.setDireccionPrincipal(new Direccion("Directorio", "5330"));
		this.agregarPasajero(pasajeroActual);
		
		this.agregarPasajero(new Pasajero("Susy Cadillac", "99-1122-3344"));
		this.agregarPasajero(new Pasajero("Elton John", "99-7777-8866"));
		
		this.agregados.agregarPasajerosAdicionales();
	}

	private void cargarChoferesIniciales() {
		this.agregarChofer(new Chofer("11111", "Pepe"));
		this.agregarChofer(new Chofer("22222", "Mariela"));
		this.agregarChofer(new Chofer("02248 334910", "Josefa"));
		this.agregados.agregarChoferesAdicionales();
	}

	private void cargarViajesIniciales() {
		Pasajero ricky = this.getPasajeroConNombre("Ricky Maravilla");
		Viaje viajeActual;

		viajeActual = new Viaje(ricky, new Direccion("José Bonifacio", "2429"));
		this.seRecibioPedido(viajeActual);
		this.seAsignoViaje(viajeActual, this.getChoferConNombre("Mariela"), 3);
		this.seTerminoViaje(viajeActual, new Direccion("José María Moreno", "1427"), 220);
		
		viajeActual = new Viaje(ricky, ricky.getDireccionPrincipal());
		this.seRecibioPedido(viajeActual);
		this.seAsignoViaje(viajeActual, this.getChoferConNombre("Pepe"), 12);
		
		Pasajero susy = this.getPasajeroConNombre("Susy Cadillac");
		viajeActual = new Viaje(susy, new Direccion("Asunción", "2608"));
		this.seRecibioPedido(viajeActual);
		
		this.agregados.agregarViajesAdicionales();
	}	
	
	public void agregarPasajero(Pasajero nuevoPasajero) {
		this.pasajeros.add(nuevoPasajero);
	}
	
	public Pasajero getPasajeroConNombre(String nombrePas) {
		return this.pasajeros.stream().filter((pas) -> pas.getNomApe().equals(nombrePas)).findAny().get();
	}

	public void agregarChofer(Chofer nuevoChofer) {
		this.choferes.add(nuevoChofer);
	}

	public List<Chofer> getChoferes() { return this.choferes; }	

	public Chofer getChoferConNombre(String nombreCho) {
		return this.choferes.stream().filter((cho) -> cho.getNombre().equals(nombreCho)).findAny().get();
	}
	
	public void seRecibioPedido(Viaje viaje) {
		viaje.setNumero(Ticketeador.tick().darTicket());
		viaje.setEstado(EstadoDeViaje.PENDIENTE);
		viajes.add(viaje);
	}
	
	public void seAsignoViaje(Viaje viaje, Chofer chofer, int demora) {
		// hago lo de mi modulo
		viaje.setTiempoDeDemora(demora);
		viaje.setEstado(EstadoDeViaje.EN_VIAJE);
		viaje.setChofer(chofer);
		// le aviso a mis observadores de otros modulos
		this.informarAsignacionViaje(
				viaje.getQuienLoPidio().getNroTelefono(), 
				viaje.getOrigen().getCalle(), 
				viaje.getOrigen().getNumero(), 
				chofer.getNroTelefono());
	}
	
	public void seDescartoViaje(Viaje viaje) {
		viaje.setEstado(EstadoDeViaje.DESCARTADO);
	}
	
	public void seTerminoViaje(Viaje viaje, Direccion destino, int precio) {
		viaje.setEstado(EstadoDeViaje.TERMINADO);
		viaje.setDestino(destino);
		viaje.setPrecio(precio);
		this.informarFinViaje(
				viaje.getQuienLoPidio().getNroTelefono(),
				destino.getCalle(),
				destino.getNumero(),
				viaje.getChofer().getNroTelefono());
	}
	
	/**
	 * Requerimiento 1
	 */
	public List<Viaje> getViajesPendientes() {
		return this.getViajes().stream().filter(viaje -> viaje.estaPendiente()).collect(Collectors.toList());
	}
	
	public List<Viaje> getViajesResueltos(LocalDate fecha) {
		return this.getViajes().stream()
				.filter(viaje -> viaje.estaResuelto() && viaje.esDelDia(fecha))
				.collect(Collectors.toList());
	}
	
	/**
	 * Requerimiento 2
	 */
	public long getCantidadViajesResueltos(LocalDate fecha) {
		return this.getViajesResueltos(fecha).size();
	}
	
	/**
	 * Requerimiento 3
	 */
	public List<Viaje> getViajesActuales() {
		return this.getViajes().stream().filter(viaje -> viaje.estaEnViaje()).collect(Collectors.toList());
	}
	
	/**
	 * Requerimiento que no esta en el enunciado "oficial"
	 */
	public List<Viaje> getViajesReferidosACalle(String nombreDeCalle) {
		return this.getViajes().stream()
				.filter(viaje -> viaje.esReferidoACalle(nombreDeCalle))
				.collect(Collectors.toList());
	}

	public List<Viaje> getViajesReferidosACalle_versionLarga(String nombreDeCalle) {
		return this.getViajes().stream()
				.filter(viaje -> 
							viaje.getOrigen().getCalle().equals(nombreDeCalle) || 
							viaje.getDestino().getCalle().equals(nombreDeCalle)
						)
				.collect(Collectors.toList());
	}
	
	/**
	 * Registro un nuevo observador
	 */
	public void registrarObservador(ObservadorToxiTaxi observador) {
		this.observadores.add(observador);
	}
	
	/**
	 * Informo que se asigno un pedido a un chofer
	 * - número de teléfono de pasajero.
	 * - calle y número de origen del viaje.
	 * - número de teléfono del chofer.
	 */
	public void informarAsignacionViaje(
			String nroTelPasajero, 
			String calleOrigen, String numeroOrigen,
			String nroTelChofer) {
		// es lo mismo que this.observadores.stream().forEach(action);
		for (ObservadorToxiTaxi observador : this.observadores) {
			observador.inicioViaje(nroTelPasajero, calleOrigen, numeroOrigen, nroTelChofer);
		}
	}
	
	public void informarFinViaje(
			String nroTelPasajero, 
			String calleDestino, 
			String numeroDestino, 
			String nroTelChofer) {
		this.observadores.stream().forEach(o -> o.finViaje(nroTelPasajero, calleDestino, numeroDestino, nroTelChofer));
	}
	
	public List<Viaje> getViajesDe(Pasajero pasajero) {
		return this.viajes.stream()
				.filter(v -> v.getQuienLoPidio().equals(pasajero))
				.collect(Collectors.toList());
	}
	
}























