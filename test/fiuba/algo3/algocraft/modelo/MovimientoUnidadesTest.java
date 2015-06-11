package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class MovimientoUnidadesTest {

	@Test
	public void test01_MoverUnaUnidad(){
		Mapa mapa = new Mapa();
		Marine marine = new Marine();
		mapa.agregarElemento(1, 1, marine);
		
		Assert.assertEquals(mapa.getElemento(1,1,0),marine);
		
		Collection<Posicion> caminado = mapa.moverElemento(marine, 3,3);
		
		Assert.assertEquals(3, caminado.size());
		Assert.assertEquals(mapa.getElemento(3, 3, 0),marine);
		Assert.assertNull(mapa.getElemento(1, 1, 0));
	}
	
	@Test
	public void test02_MoverUnaUnidadEsquivandoObstaculosTerrestres(){
		Mapa mapa = new Mapa();
		Marine marine = new Marine();
		ObstaculoTerrestre obs = new ObstaculoTerrestre();
		
		mapa.agregarElemento(1, 2, obs);
		mapa.agregarElemento(2, 2, obs);
		
		mapa.agregarElemento(1, 3, marine);
		
		Assert.assertEquals(mapa.getElemento(1,3,0),marine);
		Assert.assertEquals(mapa.getElemento(1,2,0),obs);
		Assert.assertEquals(mapa.getElemento(2,2,0),obs);
		
		Collection<Posicion> caminado = mapa.moverElemento(marine, 1,1);
		
		Assert.assertEquals(5, caminado.size());
		Assert.assertEquals(mapa.getElemento(1, 1, 0),marine);
		Assert.assertNull(mapa.getElemento(1, 3, 0));
	}
}