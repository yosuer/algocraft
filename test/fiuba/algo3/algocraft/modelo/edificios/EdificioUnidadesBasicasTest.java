package fiuba.algo3.algocraft.modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;

public class EdificioUnidadesBasicasTest {

	@Test
	public void test02_CrearUnaBarraca() {
		Barraca barraca = new Barraca();

		Assert.assertEquals(barraca.vidaActual(), 1000);
		Assert.assertEquals(barraca.getCostoMineral(), 150);
		Assert.assertEquals(barraca.getCostoVespeno(), 0);
		Assert.assertEquals(barraca.getNivel(), 0);
	}

	@Test
	public void test03_CrearUnAcceso() {
		Acceso acceso = new Acceso();

		Assert.assertEquals(acceso.vidaActual(), 1000);
		Assert.assertEquals(acceso.escudoRestante(), 500);
		Assert.assertEquals(acceso.getCostoMineral(), 150);
		Assert.assertEquals(acceso.getCostoVespeno(), 0);
		Assert.assertEquals(acceso.getNivel(), 0);
	}

	@Test
	public void test04_CrearUnaReservaDeReproduccion() {
		ReservaDeReproduccion reservaReprod = new ReservaDeReproduccion();

		Assert.assertEquals(reservaReprod.vidaActual(), 1000);
		Assert.assertEquals(reservaReprod.getCostoMineral(), 150);
		Assert.assertEquals(reservaReprod.getCostoVespeno(), 0);
		Assert.assertEquals(reservaReprod.getNivel(), 0);
	}

	@Test
	public void test02_CrearUnaBarracaYAgregarlaAlMapa() {
		Mapa mapa = new Mapa(40, 40);
		Barraca barraca = new Barraca();

		mapa.agregarElemento(3, 3, barraca);

		Assert.assertEquals(barraca, mapa.getElemento(3, 3, 0));
	}

	@Test
	public void test02_CrearUnaBarracaYEncolarUnMarineYExpedirMarine() {
		Mapa mapa = new Mapa(40, 40);
		mapa.aumentarPoblacion(10);
		Barraca barraca = new Barraca();
		mapa.agregarElemento(8, 8, barraca);
		for (int i = 1; i <= 12; i++)
			mapa.pasarTurnoMapa();

		barraca.crearMarine();

		for (int i = 1; i <= 5; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals("Marine", mapa.getElemento(7, 7, 0).nombre());
		Assert.assertEquals("Barraca", mapa.getElemento(8, 8, 0).nombre());
	}

	@Test
	public void test02_CrearUnaBarracaYCrear5Marine() {
		Mapa mapa = new Mapa(40, 40);
		mapa.recibirMineral(1000);
		mapa.aumentarPoblacion(10);

		Barraca barraca = new Barraca();
		mapa.agregarElemento(8, 8, barraca);
		for (int i = 1; i <= 12; i++)
			mapa.pasarTurnoMapa();

		barraca.crearMarine();
		barraca.crearMarine();
		barraca.crearMarine();
		barraca.crearMarine();
		barraca.crearMarine();

		Assert.assertEquals(4, barraca.unidadesEnProduccion());

		for (int i = 1; i <= 20; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(7, 7, 0).nombre(), "Marine");
		Assert.assertEquals(mapa.getElemento(7, 8, 0).nombre(), "Marine");
		Assert.assertEquals(mapa.getElemento(7, 9, 0).nombre(), "Marine");
		Assert.assertEquals(mapa.getElemento(8, 7, 0).nombre(), "Marine");

		Assert.assertEquals(mapa.getElemento(8, 8, 0).nombre(), "Barraca"); // barraca
	}

	@Test
	public void test03_CrearUnaBarracaYCrear4MarinesConPosicionesOcupadas() {
		Mapa mapa = new Mapa(40, 40);
		mapa.recibirMineral(1000);
		mapa.aumentarPoblacion(10);

		Barraca barraca = new Barraca();
		mapa.agregarElemento(3, 3, barraca);
		for (int i = 1; i <= 12; i++)
			mapa.pasarTurnoMapa();

		barraca.crearMarine();
		barraca.crearMarine();
		barraca.crearMarine();
		barraca.crearMarine();
		barraca.crearMarine();

		Assert.assertEquals(4, barraca.unidadesEnProduccion());

		for (int i = 1; i <= 20; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(1, 1, 0).nombre(), "Marine");
		Assert.assertEquals(mapa.getElemento(4, 3, 0).nombre(), "Marine");
		Assert.assertEquals(mapa.getElemento(3, 4, 0).nombre(), "Marine");
		Assert.assertEquals(mapa.getElemento(1, 3, 0).nombre(), "Marine");

		Assert.assertEquals(mapa.getElemento(3, 3, 0).nombre(), "Barraca"); // barraca
	}
}
