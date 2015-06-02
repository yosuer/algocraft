package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {

	@Test
	public void test01_crearJugadorConNombre(){
		Jugador jugador = new Jugador("algo3");
		
		Assert.assertEquals("algo3", jugador.nombre());
	}
	
	@Test
	public void test02_AsignarRazaAJugador(){
		Jugador jugador = new Jugador("algo3");

		jugador.asignarRaza(new Terran());
		
		//Assert.assertEquals(new Terran(), jugador.raza());
	}
	@Test
	public void test03_dosJugadoresConDistintosNombresNoSonIguales()
	{
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Martin");
		Assert.assertNotEquals(jugador1,jugador2);
	}
	@Test
	public void test04_dosJugadoresConMismoNombreSonIguales()
	{
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Juan");
		Assert.assertEquals(jugador1,jugador2);
	}
}
