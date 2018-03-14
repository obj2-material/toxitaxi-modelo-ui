package ar.unq.edu.cpi.toxitaxi.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import ar.unq.edu.cpi.toxitaxi.ui.driver1.DriverPage;
import ar.unq.edu.cpi.toxitaxi.ui.driver2.DriverPageEvolved;
import ar.unq.edu.cpi.toxitaxi.ui.second.PasajeroPageEvolved;

public class InitialMenu extends WebPage {
	private static final long serialVersionUID = 9109272240565209146L;

	public InitialMenu() {
		this.add(new Link<String>("simplePassengerPage") {
			private static final long serialVersionUID = 1769253494194105102L;

			@Override
			public void onClick() {
				this.setResponsePage(new PasajeroPage());			}
		});

		this.add(new Link<String>("secondPassengerPage") {
			private static final long serialVersionUID = 1769253494194105102L;

			@Override
			public void onClick() {
				this.setResponsePage(new PasajeroPageEvolved());
			}
		});

		this.add(new Link<String>("driverPageA") {
			private static final long serialVersionUID = 1769253494194105102L;

			@Override
			public void onClick() {
				this.setResponsePage(new DriverPage());
			}
		});
		this.add(new Link<String>("driverPageB") {
			private static final long serialVersionUID = 1769253494194105102L;

			@Override
			public void onClick() {
				this.setResponsePage(new DriverPageEvolved());
			}
		});
	}
}
