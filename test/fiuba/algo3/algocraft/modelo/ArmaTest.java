package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ArmaTest {

	@Test
	public void test01_CrearUnArmaConAtaquesYAlcance(){
		Arma arma = new ArmaSimple(10,5,9,7);
		
		Assert.assertEquals(10, arma.getDanioTierra());
		Assert.assertEquals(5, arma.getDanioAire());
		Assert.assertEquals(9, arma.getAlcanceTierra());
		Assert.assertEquals(7, arma.getAlcanceAire());
	}
}
