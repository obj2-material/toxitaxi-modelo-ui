package ar.unq.edu.cpi.toxitaxi.ui;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ar.unq.edu.cpi.toxitaxi.CallCenter;
import ar.unq.edu.cpi.toxitaxi.Pasajero;
import ar.unq.edu.cpi.toxitaxi.Viaje;

public class ViajesPasajeroPage extends WebPage {
	
	private Pasajero pasajeroSeleccionado;
	private List<Viaje> viajes;

	public ViajesPasajeroPage(Pasajero pasajeroSeleccionado) {
		this.pasajeroSeleccionado = pasajeroSeleccionado;
		this.viajes = CallCenter.unico().getViajesDe(this.pasajeroSeleccionado);
		
		this.crearTablaViajes();
		
		this.add(new Link<String>("volver") {

			@Override
			public void onClick() {
				this.setResponsePage(PasajeroPage.class);
			}
		});
	}

	private void crearTablaViajes() {
		this.add(new ListView<Viaje>("filaViaje", new PropertyModel<>(this, "viajes")) {
			private static final long serialVersionUID = 5512414749510820593L;

			@Override
			protected void populateItem(ListItem<Viaje> panel) {
				panel.add(new Label("origen", new PropertyModel<>(panel.getModelObject(), "origen.completa")));
				panel.add(new Label("destino", new PropertyModel<>(panel.getModelObject(), "destino.completa")));
				panel.add(new Label("estado", new PropertyModel<>(panel.getModelObject(), "estado")));
				panel.add(new Label("chofer", new PropertyModel<>(panel.getModelObject(), "chofer.nombre")));
			}
			
		});
	}

}
