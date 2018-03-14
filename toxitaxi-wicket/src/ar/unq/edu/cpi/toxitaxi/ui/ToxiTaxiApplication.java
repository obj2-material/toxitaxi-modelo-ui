package ar.unq.edu.cpi.toxitaxi.ui;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import ar.unq.edu.cpi.toxitaxi.CallCenter;

public class ToxiTaxiApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return InitialMenu.class;
	}

	@Override
	protected void init() {
		super.init();
		CallCenter.unico().cargarDataInicial();
		this.getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		this.getRequestCycleSettings().setResponseRequestEncoding("UTF-8"); 
	}

}
