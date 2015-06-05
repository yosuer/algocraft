package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class PosicionTest {

	@Test
	public void test01_CrearUnaPosicionConCoordenadasXYyObtenerLasCoordenadas(){
		Posicion pos = new Posicion(5,5);
		
		Assert.assertEquals(5,pos.posX());
		Assert.assertEquals(5,pos.posY());
	}
	
	@Test
	public void test01_DosPosicionesSonIgualesSiTienenLasMismasCoordenadasXY(){
		Posicion pos1 = new Posicion(1,6);
		Posicion pos2 = new Posicion(1,6);
		Posicion pos3 = new Posicion(1,3);
		
		Assert.assertEquals(pos1,pos2);
		Assert.assertNotEquals(pos1,pos3);
	}
}
