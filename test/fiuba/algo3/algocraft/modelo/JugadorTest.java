package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.Protoss;
import fiuba.algo3.algocraft.Terran;
import fiuba.algo3.algocraft.Zerg;
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

		jugador.asignarRaza(new Terran());

		//Assert.assertEquals(new Terran(), jugador.raza());
	}

	@Test
	public void test03_asignarRazaProtossAJugador() {
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
		jugador.asignarRaza(new Terran());

		Assert.assertNotNull(jugador.getFabrica());
		Assert.assertNotNull(jugador.getFabrica());
	}
}
