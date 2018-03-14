package ar.unq.edu.cpi.toxitaxi.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import ar.unq.edu.cpi.toxitaxi.CallCenter;
import ar.unq.edu.cpi.toxitaxi.Pasajero;

public class PasajeroPage extends WebPage {
	private static final long serialVersionUID = 2072977070642466177L;

	private Pasajero ricky = CallCenter.unico().getPasajeroConNombre("Ricky Maravilla");
	private Pasajero susy = CallCenter.unico().getPasajeroConNombre("Susy Cadillac");
	private Pasajero elton = CallCenter.unico().getPasajeroConNombre("Elton John");
	
	private PasajeroPageController controller = new PasajeroPageController(elton);
	
	public PasajeroPage() {
		super();
		this.add(
			new Label("nombre", new PropertyModel<>(this.controller, "pasajero.nomApe"))
		);
		this.add(
			new Label("telefono", new PropertyModel<>(this.controller, "pasajero.nroTelefono"))
		);
		
		this.add(new Link<String>("verRicky") {
			private static final long serialVersionUID = 9021969227478908209L;

			@Override
			public void onClick() {
				controller.setPasajero(ricky);
			}
		});
		
		this.add(new Link<String>("verElton") {
			private static final long serialVersionUID = 9021969227478908203L;

			@Override
			public void onClick() {
				controller.setPasajero(elton);
			}
		});

		this.add(new Link<String>("verSusy") {
			private static final long serialVersionUID = 9021969227478908231L;
			@Override
			public void onClick() {
				controller.setPasajero(susy);
			}
		});
		
		this.add(new Link<String>("volverAlMenu") {
			private static final long serialVersionUID = 9021969227478908209L;

			@Override
			public void onClick() {
				this.setResponsePage(new InitialMenu());
			}
		});

		this.add(new Link<String>("verViajes") {

			@Override
			public void onClick() {
				this.setResponsePage(new ViajesPasajeroPage(controller.getPasajero()));
			}
			
		});
	}
	

}
