package ar.unq.edu.cpi.toxitaxi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EmpresaDeRemises {

	private static EmpresaDeRemises unica = new EmpresaDeRemises();
	private DatosAgregados agregados;
	
	public static EmpresaDeRemises unica() { return unica; }

	public EmpresaDeRemises() { 
		super();
		this.agregados = new DatosAgregados();
	}
	
	private List<Agencia> agencias = new ArrayList<>();
	private List<PagoAChofer> pagosAChofer = new ArrayList<>();

	public void cargarDataInicial() {
		this.cargarAgencias();
		this.cargarPagosAChofer();
	}
	
	private void cargarAgencias() {
		this.agregarAgencia(new Agencia(new Direccion("Bolivia", "1904"), "Floresta", 2004));
		this.agregarAgencia(new Agencia(new Direccion("Corrientes", "348"), "Centro", 2007));
		this.agregarAgencia(new Agencia(new Direccion("Nueva York", "3704"), "Devoto", 2009));
		this.agregarAgencia(new Agencia(new Direccion("Humboldt", "2043"), "Palermo Holywood", 2009));
		this.agregados.agregarAgenciasAdicionales();
	}
	
	private void cargarPagosAChofer() {
		Chofer mariela = this.getChoferConNombre("Mariela");
		Chofer pepe = this.getChoferConNombre("Pepe");
		
		Agencia palermo = this.getAgenciaConNombre("Palermo Hollywood");
		Agencia centro = this.getAgenciaConNombre("Centro");
		Agencia devoto = this.getAgenciaConNombre("Devoto");
		
		mariela.recibirPago(LocalDate.of(2017, 12, 18), 3000, palermo);
		mariela.recibirPago(LocalDate.of(2018, 1, 12), 1800, centro);
		mariela.recibirPago(LocalDate.of(2018, 1, 24), 4200, centro);
		
		pepe.recibirPago(LocalDate.of(2018, 1, 15), 1700, devoto);
		pepe.recibirPago(LocalDate.of(2018, 2, 3), 3500, centro);
		
		this.agregados.cargarPagosAChoferAdicionales();
	}
	
	public List<Agencia> getAgencias() { return this.agencias; }

	public Agencia getAgenciaConNombre(String nombreAgencia) {
		Predicate<? super Agencia> condicion = (agencia) -> agencia.getNombre().equals(nombreAgencia);
		return this.agencias.stream().filter(condicion).findAny().get();
	}
	
	public void agregarAgencia(Agencia nuevaAgencia) { this.agencias.add(nuevaAgencia); }
	
	public List<Chofer> getChoferes() { return CallCenter.unico().getChoferes(); }
	
	public Chofer getChoferConNombre(String nombre) { return CallCenter.unico().getChoferConNombre(nombre); }
	
	public void agregarPagoAChofer(PagoAChofer nuevoPago) {
		this.pagosAChofer.add(nuevoPago);
	}
	
	public List<PagoAChofer> getPagosRealizados() {
		return this.pagosAChofer;
	}
}
