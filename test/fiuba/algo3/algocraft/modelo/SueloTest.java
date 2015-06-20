package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.natural.Mineral;
import fiuba.algo3.algocraft.modelo.natural.ObstaculoTerrestre;
import fiuba.algo3.algocraft.modelo.natural.Tierra;
import fiuba.algo3.algocraft.modelo.natural.Vespeno;

public class SueloTest {

	@Test
	public void test01_iniciaElMapaConTierra() {
		Mapa mapa = new Mapa(40, 40);
		
		Assert.assertTrue(mapa.getElemento(3,2,0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(4,6,0).getClass() ==	Vespeno.class);
		
		Assert.assertEquals(mapa.getElemento(9, 9, 0),new Tierra());
		
		ObstaculoTerrestre obstaculo = new ObstaculoTerrestre();
		mapa.agregarElemento(8, 7, obstaculo);
		Assert.assertEquals(mapa.getElemento(8, 7, 0),obstaculo);
		
	}
}
