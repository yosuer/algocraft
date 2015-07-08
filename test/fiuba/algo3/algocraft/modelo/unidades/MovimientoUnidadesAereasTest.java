package fiuba.algo3.algocraft.modelo.unidades;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;

public class MovimientoUnidadesAereasTest {

	@Test
	public void test01_agregarUnidadAereaAlMapa() {
		Mapa mapa = new Mapa(40, 40);
		Espectro esp = new Espectro();
		mapa.agregarElemento(3, 3, esp);

		Assert.assertEquals(esp, mapa.getElemento(3, 3, 1));
	}

	@Test
	public void test02_moverUnidadAerea() {
		Mapa mapa = new Mapa(40, 40);
		Espectro esp = new Espectro();
		mapa.agregarElemento(1, 1, esp);
		for (int i = 1; i <= 8; i++)
			mapa.pasarTurnoMapa();
		Collection<Posicion> camino = esp.mover(4, 4);

		Assert.assertEquals(3, camino.size());

		for (int i = 1; i <= 3; i++)
			mapa.pasarTurnoMapa();

		Assert.assertNull(mapa.getElemento(1, 1, 1));
		Assert.assertEquals(esp, mapa.getElemento(4, 4, 1));
		Assert.assertEquals(0, camino.size());
	}

	@Test
	public void test03_unaUnidadAereaNoObstruyeElCaminoDeUnaUnidadTerrestre() {
		Mapa mapa = new Mapa(40, 40);
		Espectro espectro = new Espectro();
		Marine marine = new Marine();
		mapa.agregarElemento(6, 6, espectro);
		mapa.agregarElemento(5, 5, marine);

		for (int i = 1; i <= 10; i++)
			mapa.pasarTurnoMapa();

		Collection<Posicion> camino = marine.mover(7, 7);

		Assert.assertEquals("Marine", mapa.getElemento(5, 5, 0).nombre());
		Assert.assertEquals("Espectro", mapa.getElemento(6, 6, 1).nombre());
		Assert.assertEquals("Tierra", mapa.getElemento(6, 6, 0).nombre());
		Assert.assertEquals(2, camino.size());

		for (int i = 1; i <= 3; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals("Marine", mapa.getElemento(7, 7, 0).nombre());
		Assert.assertEquals("Espectro", mapa.getElemento(6, 6, 1).nombre());
		Assert.assertEquals("Tierra", mapa.getElemento(5, 5, 0).nombre());
		Assert.assertEquals(0, camino.size());
	}

	public void test04_unaUnidadAereaObstruyeOtraUnidadAerea() {
		Mapa mapa = new Mapa(40, 40);
		Espectro espectro1 = new Espectro();
		Espectro espectro2 = new Espectro();
		mapa.agregarElemento(8, 8, espectro1);
		mapa.agregarElemento(9, 9, espectro2);
		for (int i = 1; i <= 8; i++)
			mapa.pasarTurnoMapa();

		List<Posicion> camino = espectro1.mover(10, 10);

		Assert.assertEquals(espectro1, mapa.getElemento(8, 8, 1));
		Assert.assertEquals(espectro2, mapa.getElemento(9, 9, 1));
		Assert.assertEquals(2, camino.size());

		System.out.println(camino);
		for (int i = 1; i <= 4; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals(espectro1, mapa.getElemento(10, 10, 1));
		Assert.assertEquals(espectro2, mapa.getElemento(9, 9, 1));
		Assert.assertEquals(0, camino.size());
	}

	public void test04_UnaUnidadAereaSeMueveYOtraUnidadAereaOcupaSuLugar() {
		Mapa mapa = new Mapa(40, 40);
		Espectro espectro1 = new Espectro();
		Espectro espectro2 = new Espectro();

		mapa.agregarElemento(2, 4, espectro1);
		mapa.agregarElemento(4, 3, espectro2);

		Collection<Posicion> caminoE2 = espectro2.mover(4, 4);
		Collection<Posicion> caminoE1 = espectro1.mover(4, 3);

		Assert.assertNull(mapa.getElemento(2, 4, 1));
		Assert.assertEquals(espectro2, mapa.getElemento(4, 1, 1));
		Assert.assertEquals(espectro1, mapa.getElemento(4, 3, 1));
		Assert.assertEquals(2, caminoE1.size());
		Assert.assertEquals(2, caminoE2.size());
	}
}
