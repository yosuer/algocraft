package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class EdificioUnidadesBasicasTest {
	
	@Test
	public void test02_CrearUnaBarraca(){
		Barraca barraca = new Barraca();
		
		Assert.assertEquals(barraca.vidaActual(), 1000);
		Assert.assertEquals(barraca.getCostoMineral(), 150);
		Assert.assertEquals(barraca.getCostoVespeno(), 0);
		Assert.assertEquals(barraca.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnAcceso(){
		Acceso acceso = new Acceso();
		
		Assert.assertEquals(acceso.vidaActual(), 1000);
		//Assert.assertEquals(acceso.escudoActual(), 500);
		Assert.assertEquals(acceso.getCostoMineral(), 150);
		Assert.assertEquals(acceso.getCostoVespeno(), 0);
		Assert.assertEquals(acceso.getNivel(), 0);
	}
	
	@Test
	public void test04_CrearUnaReservaDeReproduccion(){
		ReservaDeReproduccion reservaReprod = new ReservaDeReproduccion();
		
		Assert.assertEquals(reservaReprod.vidaActual(), 1000);
		Assert.assertEquals(reservaReprod.getCostoMineral(), 150);
		Assert.assertEquals(reservaReprod.getCostoVespeno(), 0);
		Assert.assertEquals(reservaReprod.getNivel(), 0);
	}
	
	@Test
	public void test02_CrearUnaBarracaYAgregarlaAlMapa(){
		
		
		Barraca barraca = new Barraca();
		
		Assert.assertEquals(barraca.vidaActual(), 1000);
		Assert.assertEquals(barraca.getCostoMineral(), 150);
		Assert.assertEquals(barraca.getCostoVespeno(), 0);
		Assert.assertEquals(barraca.getNivel(), 0);
	}
}
