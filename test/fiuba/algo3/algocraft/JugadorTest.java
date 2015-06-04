package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorNombreDeJugadorInvalido;

public class JugadorTest {

	@Test
	public void test01_crearJugadorConNombre() {
		Jugador jugador = new Jugador("jugador");

		Assert.assertEquals("jugador", jugador.nombre());
	}

	@Test
	public void testXXUnJugadorInicialmenteTiene500DeMineralY100DeVespeno() {
		Jugador jugador = new Jugador("jugador");

		Assert.assertEquals(jugador.mineral(), 200);
		Assert.assertEquals(jugador.vespeno(), 0);
	}

	@Test
	public void testXXXLaPoblacionInicialDeUnJugadorEs5() {
		Jugador jugador = new Jugador("jugador");

		Assert.assertEquals(jugador.poblacion(), 5);
	}

	@Test(expected = ErrorNombreDeJugadorInvalido.class)
	public void test0X_JugadorSiempreTieneNombreConMasDe4Digitos() {
		Jugador jugador = new Jugador("jug");
	}

	@Test
	public void test02_asignarRazaTerranAJugador() {
		Jugador jugador = new Jugador("jugador");

		jugador.asignarRaza(Terran.getInstance());

		Assert.assertEquals(Terran.getInstance(), jugador.raza());
	}

	@Test
	public void test03_asignarRazaProtossAJugador() {
		Jugador jugador = new Jugador("jugador");

		jugador.asignarRaza(Protoss.getInstance());

		Assert.assertEquals(Protoss.getInstance(), jugador.raza());
	}

	@Test
	public void test04_asignarRazaZergAJugador() {
		Jugador jugador = new Jugador("jugador");

		jugador.asignarRaza(Zerg.getInstance());

		Assert.assertEquals(Zerg.getInstance(), jugador.raza());
	}

	@Test
	public void test05_dosJugadoresConDistintosNombresNoSonIguales() {
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Martin");
		Assert.assertNotEquals(jugador1, jugador2);
	}

	@Test
	public void test06_dosJugadoresConMismoNombreSonIguales() {
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Juan");
		Assert.assertEquals(jugador1, jugador2);
	}

	@Test
	public void test07_ElJugadorDevuelveSuFabricaSegunSuRaza() {
		Jugador jugador = new Jugador("jugador");
		jugador.asignarRaza(Terran.getInstance());

		Assert.assertNotNull(jugador.getFabrica());
		Assert.assertNotNull(jugador.getFabrica());
	}
}
