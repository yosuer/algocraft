package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class EdificioConstructorDeNavesTest {
	
	@Test
	public void test01_CrearUnPuertoEstelarTerran(){
		Mapa mapa = new Mapa();
		PuertoEstelarTerran puertoEstelar = new PuertoEstelarTerran(mapa);
		
		Assert.assertEquals(puertoEstelar.vidaActual(), 1300);
		Assert.assertEquals(puertoEstelar.getCostoMineral(), 150);
		Assert.assertEquals(puertoEstelar.getCostoVespeno(), 100);
		Assert.assertEquals(puertoEstelar.getNivel(), 0);
	}
	
	@Test
	public void test02_CrearUnPuertoEstelarProtoss(){
		Mapa mapa = new Mapa();
		PuertoEstelarProtoss puertoEstelar = new PuertoEstelarProtoss(mapa);
		
		Assert.assertEquals(puertoEstelar.vidaActual(), 1200);
		//Assert.assertEquals(acceso.escudoActual(), 600);
		Assert.assertEquals(puertoEstelar.getCostoMineral(), 150);
		Assert.assertEquals(puertoEstelar.getCostoVespeno(), 150);
		Assert.assertEquals(puertoEstelar.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnaReservaDeReproduccion(){
		Mapa mapa = new Mapa();
		Espiral espiral = new Espiral(mapa);
		
		Assert.assertEquals(espiral.vidaActual(), 1200);
		Assert.assertEquals(espiral.getCostoMineral(), 150);
		Assert.assertEquals(espiral.getCostoVespeno(), 150);
		Assert.assertEquals(espiral.getNivel(), 0);
	}

}
