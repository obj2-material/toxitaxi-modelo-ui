package ar.unq.edu.cpi.toxitaxi;

import java.io.Serializable;

public class Ticketeador implements Serializable {
	private static Ticketeador laUnica = new Ticketeador();

	public static Ticketeador tick() { return laUnica; }
	
	/** 
	 * Para forzar singleton, hago el constructor privado
	 */
	private Ticketeador() { }

	private long ultimoNumero = 0;

	public long darTicket() { return ++this.ultimoNumero; }
}
