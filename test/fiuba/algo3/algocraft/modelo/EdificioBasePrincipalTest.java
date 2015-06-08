package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class EdificioBasePrincipalTest {
	
	@Test
	public void test01_CrearUnCentroDeMando(){
		CentroDeMando centroDeMando = new CentroDeMando();
		
		Assert.assertEquals(centroDeMando.vidaActual(), 1500);
		Assert.assertEquals(centroDeMando.getCostoMineral(), 100);
		Assert.assertEquals(centroDeMando.getCostoVespeno(), 100);
		Assert.assertEquals(centroDeMando.getNivel(), 0);
	}
	
	@Test
	public void test02_CrearUnNexo(){
		Nexo nexo = new Nexo();
		
		Assert.assertEquals(nexo.vidaActual(), 1500);
		//Assert.assertEquals(acceso.escudoActual(), 750);
		Assert.assertEquals(nexo.getCostoMineral(), 100);
		Assert.assertEquals(nexo.getCostoVespeno(), 100);
		Assert.assertEquals(nexo.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnCriadero(){
		Criadero criadero = new Criadero();
		
		Assert.assertEquals(criadero.vidaActual(), 1500);
		Assert.assertEquals(criadero.getCostoMineral(), 100);
		Assert.assertEquals(criadero.getCostoVespeno(), 100);
		Assert.assertEquals(criadero.getNivel(), 0);
	}
}
