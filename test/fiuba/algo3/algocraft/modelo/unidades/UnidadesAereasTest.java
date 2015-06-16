package fiuba.algo3.algocraft.modelo.unidades;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarTerran;
import fiuba.algo3.algocraft.modelo.unidades.Espectro;

public class UnidadesAereasTest {
	
	@Test
	public void test00_PasarTurnoEspectro() {
		Mapa mapa = new Mapa();
		Espectro espectro = new Espectro();
		mapa.agregarElemento(2, 2, espectro);
		
		mapa.pasarTurnoMapa();
	}
	
	@Test
	public void test01_CrearNavesTerran() {
		Mapa mapa = new Mapa();
		mapa.recibirMineral(500);
		mapa.recibirVespeno(500); //inyecto recursos para pruebas
		
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa();
		
		Fabrica fabrica = new Fabrica();
		mapa.agregarElemento(4, 4, fabrica);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa();
		
		PuertoEstelarTerran puerto = new PuertoEstelarTerran();
		mapa.agregarElemento(3, 3, puerto);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa();
		
		puerto.crearEspectro();

		Assert.assertNull(mapa.getElemento(2, 2, 1));
		for (int i=1; i <=9; i++) mapa.pasarTurnoMapa();
		
		Espectro espectro = (Espectro) mapa.getElemento(2, 2, 1);
		Assert.assertEquals(espectro.vidaActual(),120);
		Assert.assertEquals(espectro.getCostoMineral(),150);
		Assert.assertEquals(espectro.getCostoVespeno(),100);
	}
}
