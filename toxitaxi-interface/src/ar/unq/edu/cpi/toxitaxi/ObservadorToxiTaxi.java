package ar.unq.edu.cpi.toxitaxi;

public interface ObservadorToxiTaxi {

	public void inicioViaje(String nroTelPasajero, String calleOrigen, String numeroOrigen, String nroTelChofer);
	public void finViaje(String nroTelefonoPasajero, String calleDestino, String numeroDestino, String nroTelChofer);

}
