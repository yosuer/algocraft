package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorNombreDeJugadorInvalido;

public class JugadorTest {

	@Test
	public void test01_crearJugadorConNombre(){
		Jugador jugador = new Jugador("jugador");
		
		Assert.assertEquals("jugador", jugador.nombre());
	}
	
	@Test(expected = ErrorNombreDeJugadorInvalido.class)
	public void test0X_JugadorSiempreTieneNombreConMasDe4Digitos(){
		Jugador jugador = new Jugador("jug");
	}
	
	@Test
	public void test02_asignarRazaTerranAJugador(){
		Jugador jugador = new Jugador("jugador");

		jugador.asignarRaza(new Terran());
		
		//Assert.assertEquals(new Terran(), jugador.raza());
	}
	
	@Test
	public void test03_asignarRazaProtossAJugador(){
		Jugador jugador = new Jugador("jugador");
		
		jugador.asignarRaza(new Protoss());
		
		//Assert.assertEquals(new Protoss(), jugador.raza());
	}
	
	@Test
	public void test04_asignarRazaZergAJugador() {
		Jugador jugador = new Jugador("jugador");
		
		jugador.asignarRaza(new Zerg());
		
		//Assert.assertEquals(new Zerg(), jugador.raza());
	}
	
	@Test
	public void test05_dosJugadoresConDistintosNombresNoSonIguales()
	{
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Martin");
		Assert.assertNotEquals(jugador1,jugador2);
	}
	@Test
	public void test06_dosJugadoresConMismoNombreSonIguales()
	{
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Juan");
		Assert.assertEquals(jugador1,jugador2);
	}
}
