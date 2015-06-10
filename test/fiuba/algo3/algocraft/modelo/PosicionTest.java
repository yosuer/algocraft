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
	
	@Test
	public void test03_ToStringPosicion(){
		Posicion pos1 = new Posicion(1,6,1);
		Posicion pos2 = new Posicion(53,30,1);
		Posicion pos3 = new Posicion(9,99,1);
		
		Assert.assertEquals(pos1.toString(),"1,6");
		Assert.assertEquals(pos2.toString(),"53,30");
		Assert.assertEquals(pos3.toString(),"9,99");
	}
}
