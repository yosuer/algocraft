package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ArmaTest {

	@Test
	public void test01_CrearUnArmaConAtaquesYAlcance(){
		IArma arma = new ArmaSimple(10,5,9,7);
		
		Assert.assertEquals(10, arma.getDanio(0));
		Assert.assertEquals(5, arma.getDanio(1));
		Assert.assertEquals(9, arma.getAlcance(0));
		Assert.assertEquals(7, arma.getAlcance(1));
	}
}
