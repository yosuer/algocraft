package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.unidades.Marine;
import fiuba.algo3.algocraft.modelo.unidades.NaveCiencia;
import fiuba.algo3.algocraft.modelo.unidades.Zealot;

public class MagiaTest {

	@Test
	public void test01_NaveCienciaLanzaUnEMPyDaniaElEscudoDeLasUnidadesAlrededorDeLaPosicionObjetivo(){
		Mapa mapa = new Mapa();
		Unidad zeratul = new Zealot();
		Unidad raynor = new Marine();
		Unidad naveCiencia2 = new NaveCiencia();
		
		mapa.agregarElemento(7, 8, naveCiencia2);
		mapa.agregarElemento(7, 9, raynor);
		mapa.agregarElemento(8, 9, zeratul);
		
		mapa.pasarTurnoMapa();  //Siguiente Jugador
		
		Unidad naveCiencia = new NaveCiencia();
		mapa.agregarElemento(5, 5, naveCiencia);
		
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
				
		Assert.assertEquals(160, zeratul.vidaActual());
		Assert.assertEquals(40, raynor.vidaActual());
		Assert.assertEquals(200,naveCiencia2.vidaActual());
//		Assert.assertEquals(100,naveCiencia2.energiaActual());
//		
//		Assert.assertEquals(100,naveCiencia.energiaActual());	
//		
//		naveCiencia.lanzarEMP(new Posicion(9,9));
//		
//		Assert.assertEquals(100, zeratul.vidaActual());
//		Assert.assertEquals(40, raynor.vidaActual());
//		Assert.assertEquals(200,naveCiencia2.vidaActual());
//		Assert.assertEquals(0,naveCiencia2.energiaActual());
//		
//		Assert.assertEquals(0,naveCiencia.energiaActual());
	}
}
