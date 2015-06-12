package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class EdificioConstructorDeNavesTest {
	
	@Test
	public void test01_CrearUnPuertoEstelarTerran(){
		PuertoEstelarTerran puertoEstelar = new PuertoEstelarTerran();
		
		Assert.assertEquals(puertoEstelar.vidaActual(), 1300);
		Assert.assertEquals(puertoEstelar.getCostoMineral(), 150);
		Assert.assertEquals(puertoEstelar.getCostoVespeno(), 100);
		Assert.assertEquals(puertoEstelar.getNivel(), 0);
	}
	
	@Test
	public void test02_CrearUnPuertoEstelarProtoss(){
		PuertoEstelarProtoss puertoEstelar = new PuertoEstelarProtoss();
		
		Assert.assertEquals(puertoEstelar.vidaActual(), 1200);
		Assert.assertEquals(puertoEstelar.escudoRestante(), 600);
		Assert.assertEquals(puertoEstelar.getCostoMineral(), 150);
		Assert.assertEquals(puertoEstelar.getCostoVespeno(), 150);
		Assert.assertEquals(puertoEstelar.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnaReservaDeReproduccion(){
		Espiral espiral = new Espiral();
		
		Assert.assertEquals(espiral.vidaActual(), 1300);
		Assert.assertEquals(espiral.getCostoMineral(), 150);
		Assert.assertEquals(espiral.getCostoVespeno(), 150);
		Assert.assertEquals(espiral.getNivel(), 0);
	}

}
