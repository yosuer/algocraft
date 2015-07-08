package fiuba.algo3.algocraft.modelo.unidades;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.ArchivoTemplario;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarTerran;

public class UnidadesAereasTest {

	@Test
	public void test00_PasarTurnoEspectro() {
		Mapa mapa = new Mapa(40, 40);
		Espectro espectro = new Espectro();
		mapa.agregarElemento(2, 2, espectro);

		mapa.pasarTurnoMapa();
	}

	@Test
	public void test01_CrearNavesTerran() {
		Mapa mapa = new Mapa(40, 40);
		mapa.recibirMineral(500);
		mapa.recibirVespeno(500); // inyecto recursos para pruebas

		Barraca barraca = new Barraca();
		mapa.agregarElemento(5, 5, barraca);
		for (int i = 1; i <= 12; i++)
			mapa.pasarTurnoMapa();

		Fabrica fabrica = new Fabrica();
		mapa.agregarElemento(5, 4, fabrica);
		for (int i = 1; i <= 12; i++)
			mapa.pasarTurnoMapa();

		PuertoEstelarTerran puerto = new PuertoEstelarTerran();
		mapa.agregarElemento(7, 7, puerto);
		for (int i = 1; i <= 12; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals("PuertoEstelarTerran", mapa.getElemento(7, 7, 0)
				.nombre());
		puerto.crearEspectro();

		Assert.assertNull(mapa.getElemento(7, 7, 1));
		for (int i = 1; i <= 9; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals("PuertoEstelarTerran", mapa.getElemento(7, 7, 0)
				.nombre());
		Espectro espectro = (Espectro) mapa.getElemento(7, 7, 1);
		Assert.assertEquals("Espectro", mapa.getElemento(7, 7, 1).nombre());
		Assert.assertEquals(espectro.vidaActual(), 120);
		Assert.assertEquals(espectro.getCostoMineral(), 150);
		Assert.assertEquals(espectro.getCostoVespeno(), 100);
	}

	@Test
	public void test02_CrearNavesProtoss() {
		Mapa mapa = new Mapa(40, 40);
		mapa.recibirMineral(500);
		mapa.recibirVespeno(500); // inyecto recursos para pruebas

		Acceso acceso = new Acceso();
		mapa.agregarElemento(5, 5, acceso);
		for (int i = 1; i <= 12; i++)
			mapa.pasarTurnoMapa();

		ArchivoTemplario archivo = new ArchivoTemplario();
		mapa.agregarElemento(4, 5, archivo);
		for (int i = 1; i <= 12; i++)
			mapa.pasarTurnoMapa();

		PuertoEstelarProtoss puerto = new PuertoEstelarProtoss();
		mapa.agregarElemento(7, 7, puerto);
		for (int i = 1; i <= 11; i++)
			mapa.pasarTurnoMapa();

		puerto.crearScout();

		for (int i = 1; i <= 13; i++)
			mapa.pasarTurnoMapa();

		Assert.assertEquals("PuertoEstelarProtoss", mapa.getElemento(7, 7, 0)
				.nombre());
		Assert.assertEquals("Scout", mapa.getElemento(7, 7, 1).nombre());
		Scout scout = (Scout) mapa.getElemento(7, 7, 1);
		Assert.assertEquals(scout.vidaActual(), 250);
	}
}
