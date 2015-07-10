package fiuba.algo3.algocraft.modelo.unidades;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.natural.ObstaculoTerrestre;
import fiuba.algo3.algocraft.modelo.natural.Tierra;

public class MovimientoUnidadesTest {

	@Test
	public void test01_LasUnidadesSeMuevenDeA1PosicionPorTurno() {
		Mapa mapa = new Mapa(40, 40);
		Marine marine = new Marine();
		mapa.agregarElemento(3, 3, marine);
		for (int i = 1; i <= 4; i++)
			mapa.pasarTurnoMapa();

		Collection<Posicion> caminado = marine.mover(5, 5);

		Assert.assertEquals(mapa.getElemento(3, 3, 0), marine);
		Assert.assertEquals(2, caminado.size());

		mapa.pasarTurnoMapa();

		Assert.assertEquals(1, caminado.size());
		Assert.assertEquals(mapa.getElemento(4, 4, 0), marine);

		mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(3, 3, 0), new Tierra());
		Assert.assertEquals(mapa.getElemento(4, 4, 0), new Tierra());
		Assert.assertEquals(0, caminado.size());
		Assert.assertEquals(mapa.getElemento(5, 5, 0), marine);
	}

	@Test
	public void test02_MoverUnaUnidadEsquivandoObstaculosTerrestres() {
		Mapa mapa = new Mapa(40, 40);
		Marine marine = new Marine();
		ObstaculoTerrestre obs = new ObstaculoTerrestre();

		mapa.agregarElemento(1, 2, obs);
		mapa.agregarElemento(1, 3, marine);
		for (int i = 1; i <= 4; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(1, 3, 0), marine);
		Assert.assertEquals(mapa.getElemento(1, 2, 0), obs);

		Collection<Posicion> caminado = marine.mover(1, 1);
		Assert.assertEquals(15, caminado.size());

		for (int i = 1; i <= 15; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(mapa.getElemento(1, 3, 0), new Tierra());
		Assert.assertEquals(mapa.getElemento(1, 1, 0), marine);
	}

	@Test
	public void test03_UnaUnidadTerrestreNoObstruyeElCaminoDeUnaUnidadAerea() {
		Mapa mapa = new Mapa(40, 40);
		Espectro espectro = new Espectro();
		Marine marine = new Marine();
		mapa.agregarElemento(2, 2, espectro);
		mapa.agregarElemento(3, 3, marine);
		for (int i = 1; i <= 8; i++)
			mapa.pasarTurnoMapa();

		Collection<Posicion> camino = espectro.mover(4, 4);

		Assert.assertEquals(espectro, mapa.getElemento(2, 2, 1));
		Assert.assertEquals(marine, mapa.getElemento(3, 3, 0));
		Assert.assertEquals(2, camino.size());

		mapa.pasarTurnoMapa();

		Assert.assertNull(mapa.getElemento(2, 2, 1));
		Assert.assertEquals(espectro, mapa.getElemento(3, 3, 1));
		Assert.assertEquals(marine, mapa.getElemento(3, 3, 0));
		Assert.assertEquals(1, camino.size());
	}
}
