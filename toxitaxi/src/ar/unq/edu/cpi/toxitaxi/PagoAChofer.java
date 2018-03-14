package ar.unq.edu.cpi.toxitaxi;

import java.time.LocalDate;

public class PagoAChofer {

	private LocalDate fecha;
	private Chofer chofer;
	private long importe;
	private Agencia agencia;
	private long numero;
	
	public PagoAChofer() {
		super();
		this.numero = Ticketeador.tick().darTicket();
	}
	
	public PagoAChofer(LocalDate fecha, Chofer chofer, long importe, Agencia agencia) {
		this();
		this.fecha = fecha;
		this.chofer = chofer;
		this.importe = importe;
		this.agencia = agencia;
	}


	public LocalDate getFecha() { return this.fecha; }
	public void setFecha(LocalDate _fecha) { this.fecha = _fecha; }
	public Chofer getChofer() { return this.chofer; }
	public void setChofer(Chofer _chofer) { this.chofer = _chofer; }
	public long getImporte() { return this.importe; }
	public void setImporte(long _importe) { this.importe = _importe; }
	public Agencia getAgencia() { return this.agencia; }
	public void setAgencia(Agencia _agencia) { this.agencia = _agencia; }
	
}
