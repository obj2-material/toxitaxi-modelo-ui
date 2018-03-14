package toxitaxi;

import static org.junit.Assert.*;

import org.junit.Test;

public class MayusculaTest {

	@Test
	public void testMayuscula() {
		assertEquals("HOLA AMIGOS", "HoLa amigoS".toUpperCase());
	}
	
	@Test
	public void testComparacion() {
		assertEquals("corRientes".toUpperCase(), "Corrientes".toUpperCase());
	}

}
