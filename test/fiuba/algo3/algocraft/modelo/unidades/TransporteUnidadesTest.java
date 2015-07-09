package fiuba.algo3.algocraft.modelo.unidades;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.natural.Tierra;

public class TransporteUnidadesTest {

	@Test
	public void test01_NaveDeTransporteTrasladaLaUnidadYSeDesocupaLaPosicionYDescargaEnOtraPosicionLaUnidad() {
		Mapa mapa = new Mapa(40, 40);
		Marine marine = new Marine();
		NaveTransporteTerran nave = new NaveTransporteTerran();

		mapa.agregarElemento(5, 5, marine);
		mapa.agregarElemento(6, 6, nave);

		Assert.assertEquals(mapa.getElemento(5, 5, 0), marine);

		nave.transportar(marine);

		Assert.assertEquals(mapa.getElemento(5, 5, 0), new Tierra());

		nave.descargar(6, 6);

		Assert.assertEquals(mapa.getElemento(6, 6, 0), marine);
		Assert.assertEquals(mapa.getElemento(5, 5, 0).nombre(), "Tierra");
		Assert.assertEquals(mapa.getElemento(6, 6, 1), nave);
	}

	@Test
	public void test02_NaveDeTransporteTraslada2UnidadesYSeDesocupaLaPosicionYDescargaEnOtraPosicionLaUnidad() {
		Mapa mapa = new Mapa(40, 40);
		Marine marine1 = new Marine();
		Marine marine2 = new Marine();
		NaveTransporteTerran nave = new NaveTransporteTerran();

		mapa.agregarElemento(5, 5, marine1);
		mapa.agregarElemento(5, 6, marine2);
		mapa.agregarElemento(6, 6, nave);

		for (int i = 1; i <= 8; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(5, 5, 0), marine1);
		Assert.assertEquals(mapa.getElemento(5, 6, 0), marine2);
		Assert.assertEquals(mapa.getElemento(6, 6, 1), nave);

		nave.transportar(marine1);
		nave.transportar(marine2);

		nave.mover(8, 8);

		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();

		nave.descargar();

		Assert.assertEquals(mapa.getElemento(5, 5, 0), new Tierra());
		Assert.assertEquals(mapa.getElemento(5, 6, 0), new Tierra());
		Assert.assertNull(mapa.getElemento(6, 6, 1));
		Assert.assertEquals(mapa.getElemento(8, 8, 0), marine1);
		Assert.assertEquals(mapa.getElemento(7, 7, 0), marine2);
		Assert.assertEquals(mapa.getElemento(8, 8, 1), nave);
	}

	@Test
	public void test03_NaveDeTransporteTraslada2UnidadesYSeDesocupaLaPosicionYDescargaEnOtraPosicionLaUnidad() {
		Mapa mapa = new Mapa(40, 40);
		Marine marine1 = new Marine();
		Marine marine2 = new Marine();
		NaveTransporteTerran nave = new NaveTransporteTerran();

		mapa.agregarElemento(5, 5, marine1);
		mapa.agregarElemento(5, 6, marine2);
		mapa.agregarElemento(6, 6, nave);

		for (int i = 1; i <= 8; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(5, 5, 0), marine1);
		Assert.assertEquals(mapa.getElemento(5, 6, 0), marine2);
		Assert.assertEquals(mapa.getElemento(6, 6, 1), nave);

		nave.transportar(marine1);
		nave.transportar(marine2);

		nave.mover(8, 8);

		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();

		nave.descargar();

		marine1 = (Marine) mapa.getElemento(8, 8, 0);

		marine1.mover(10, 10);

		for (int i = 1; i <= 8; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(10, 10, 0).nombre(), "Marine");
		Assert.assertEquals(mapa.getElemento(5, 5, 0).nombre(), "Tierra");
		Assert.assertEquals(mapa.getElemento(5, 6, 0).nombre(), "Tierra");
		Assert.assertEquals("Tierra", mapa.getElemento(8, 8, 0).nombre());

	}

}
