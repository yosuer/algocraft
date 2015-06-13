package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class AmoSupremoTest {

	@Test
	public void test01_CrearAmoSupremo(){
		AmoSupremo amo = new AmoSupremo();
		
		Assert.assertEquals(amo.vidaActual(), 200);
		Assert.assertEquals(amo.getCostoMineral(), 100);
		Assert.assertEquals(amo.getCostoVespeno(), 0);
		Assert.assertEquals(amo.getNivel(),1);
	}
	
	@Test
	public void test02_AgregarUnAmoSupremoAlMapaAumentaPoblacion(){
		Mapa mapa = new Mapa(); //poblacion inicial es 10
		AmoSupremo amo = new AmoSupremo();
		
		mapa.agregarElemento(1, 1, amo);
		
		Assert.assertEquals(15.0,mapa.getPoblacionTotal(),0.0);
	}
	
	@Test
	public void test03_EliminarUnAmoSupremoDelMapaDisminuyePoblacion(){
		Mapa mapa = new Mapa(); //poblacion inicial es 10

		mapa.agregarElemento(1, 1, new AmoSupremo());
		mapa.agregarElemento(3, 3, new AmoSupremo());
		
		Assert.assertEquals(20.0, mapa.getPoblacionTotal(),0.0);
		
		mapa.getElemento(1, 1, 1).eliminarseDelMapa(mapa);
		mapa.getElemento(3, 3, 1).eliminarseDelMapa(mapa);
		Assert.assertEquals(10.0, mapa.getPoblacionTotal(), 0.0);
	}
	
}
