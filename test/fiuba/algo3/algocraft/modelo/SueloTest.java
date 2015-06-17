package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class SueloTest {

	public void test01_iniciaElMapaConTierra() {
		Mapa mapa = new Mapa();
		
		Assert.assertTrue(mapa.getElemento(3,2,0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(4,6,0).getClass() ==	Vespeno.class);
		
		Assert.assertTrue(mapa.getElemento(9,9,0).getClass() == Tierra.class);
		
		//Assert.assertNull(mapa.getElemento(9, 9, 0));
		
		ObstaculoTerrestre obstaculo = new ObstaculoTerrestre();
		mapa.agregarElemento(8, 7, obstaculo);
		Assert.assertEquals(mapa.getElemento(8, 7, 0),obstaculo);
		
	}
}
