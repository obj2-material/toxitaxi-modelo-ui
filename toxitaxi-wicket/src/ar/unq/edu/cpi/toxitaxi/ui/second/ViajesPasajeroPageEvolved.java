package ar.unq.edu.cpi.toxitaxi.ui.second;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import ar.unq.edu.cpi.toxitaxi.Chofer;
import ar.unq.edu.cpi.toxitaxi.Viaje;

public class ViajesPasajeroPageEvolved extends WebPage {
	private static final long serialVersionUID = -1061824403496088979L;

	private PasajeroPageControllerEvolved controller;

	public ViajesPasajeroPageEvolved(PasajeroPageControllerEvolved _controller) {
		this.controller = _controller;
		
		this.agregarDatosPasajero();
		this.crearTablaViajes();
		this.agregarDatosChofer();
		
		this.add(new Link<String>("volver") {
			private static final long serialVersionUID = 539552077908712049L;

			@Override
			public void onClick() {
				this.setResponsePage(new PasajeroPageEvolved(ViajesPasajeroPageEvolved.this.controller));
			}
		});
	}

	private void agregarDatosPasajero() {
		this.add(new Label("nombrePas", new PropertyModel<>(this.controller, "pasajero.nomApe")));
		this.add(new Label("telefonoPas", new PropertyModel<>(this.controller, "pasajero.nroTelefono")));
		this.add(new Label("direccionPrincipalPas", new PropertyModel<>(this.controller, "pasajero.direccionPrincipal.completa")));
	}

	private void agregarDatosChofer() {
		WebMarkupContainer panelChofer = new WebMarkupContainer("datosChofer");
		
		panelChofer.add(new Label("nombreCho", new PropertyModel<>(this.controller, "chofer.nombre")));
		panelChofer.add(new Label("telefonoCho", new PropertyModel<>(this.controller, "chofer.nroTelefono")));
		panelChofer.add(new Label("cantidadViajesCho", new PropertyModel<>(this.controller, "chofer.cantidadViajes")));
		panelChofer.add(new Label("estaEnViajeCho", new PropertyModel<>(this.controller, "chofer.estaEnViaje")));
		
		panelChofer.setVisible(false);
		this.add(panelChofer);
	}

	private void crearTablaViajes() {
		this.add(new ListView<Viaje>("filaViaje", new PropertyModel<>(this.controller, "viajes")) {
			private static final long serialVersionUID = 6894577007490096013L;

			@Override
			protected void populateItem(ListItem<Viaje> panel) {
				CompoundPropertyModel<Viaje> viaje = new CompoundPropertyModel<>(panel.getModelObject());
				panel.add(new Label("origenViaje", viaje.bind("origen.completa")));
				panel.add(new Label("destinoViaje", viaje.bind("destino.completa")));
				panel.add(new Label("estadoViaje", viaje.bind("estado")));
				
				Link<String> linkChofer = new Link<String>("choferViaje") {
					private static final long serialVersionUID = -8643817356638158028L;

					@Override
					public void onClick() {
						ViajesPasajeroPageEvolved.this.elegirChofer(viaje.getObject().getChofer());
					}
				};
				linkChofer.setBody(new PropertyModel<>(viaje.getObject(), "chofer.nombre"));
				panel.add(linkChofer);
				
				/*
				 * El agregado del link al chofer, sin necesidad de definir la variable.
				 * Para entender qué pasa acá, leer el código *muy* despacito.
				 * Ayuda: el método setBody devuelve this
				 
					panel.add(new Link<String>("choferViaje") {
						private static final long serialVersionUID = -8643817356638158028L;
	
						@Override
						public void onClick() {
							ViajesPasajeroPageEvolved.this.elegirChofer(viaje.getObject().getChofer());
						}
					}.setBody(new PropertyModel<>(viaje.getObject(), "chofer.nombre")));
					
				 */
			}
			
		});
	}

	protected void elegirChofer(Chofer elChofer) {
		this.controller.setChofer(elChofer);
		this.get("datosChofer").setVisible(true);
	}

}
