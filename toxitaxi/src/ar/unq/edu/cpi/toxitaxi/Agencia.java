package ar.unq.edu.cpi.toxitaxi;

public class Agencia {
	private Direccion direccion;
	private String nombre;
	private int anioDeApertura;
	
	public Agencia(Direccion _direccion, String _nombre, int _anioDeApertura) {
		super();
		this.direccion = _direccion;
		this.nombre = _nombre;
		this.anioDeApertura = _anioDeApertura;
	}
	
	public Direccion getDireccion() { return this.direccion; }
	public String getNombre() { return this.nombre; }
	public int getAnioDeApertura() { return this.anioDeApertura; }	
}
