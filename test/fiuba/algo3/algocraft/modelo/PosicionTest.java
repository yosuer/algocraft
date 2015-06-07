package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class PosicionTest {

	@Test
	public void test01_CrearUnaPosicionConCoordenadasXYZyObtenerLasCoordenadas(){
		Posicion pos = new Posicion(5,5,5);
		
		Assert.assertEquals(5,pos.x());
		Assert.assertEquals(5,pos.y());
		Assert.assertEquals(5,pos.z());
	}
	
	@Test
	public void test01_DosPosicionesSonIgualesSiTienenLasMismasCoordenadasXY(){
		Posicion pos1 = new Posicion(1,6,1);
		Posicion pos2 = new Posicion(1,6,1);
		Posicion pos3 = new Posicion(1,3,1);
		
		Assert.assertEquals(pos1,pos2);
		Assert.assertNotEquals(pos1,pos3);
	}
}
