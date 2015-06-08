package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class EdificioUnidadesBasicasTest {
	
	@Test
	public void test01_CrearUnidadesYVerificarPropiedasBasicas(){
		
	}
	
	@Test
	public void test02_CrearUnaBarraca(){
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca(mapa);
		
		Assert.assertEquals(barraca.vidaActual(), 1000);
		Assert.assertEquals(barraca.getCostoMineral(), 150);
		Assert.assertEquals(barraca.getCostoVespeno(), 0);
		Assert.assertEquals(barraca.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnAcceso(){
		Mapa mapa = new Mapa();
		Acceso acceso = new Acceso(mapa);
		
		Assert.assertEquals(acceso.vidaActual(), 1000);
		//Assert.assertEquals(acceso.escudoActual(), 500);
		Assert.assertEquals(acceso.getCostoMineral(), 150);
		Assert.assertEquals(acceso.getCostoVespeno(), 0);
		Assert.assertEquals(acceso.getNivel(), 0);
	}
	
	@Test
	public void test04_CrearUnaReservaDeReproduccion(){
		Mapa mapa = new Mapa();
		CentroDeReproduccion reservaReprod = new CentroDeReproduccion(mapa);
		
		Assert.assertEquals(reservaReprod.vidaActual(), 1000);
		Assert.assertEquals(reservaReprod.getCostoMineral(), 150);
		Assert.assertEquals(reservaReprod.getCostoVespeno(), 0);
		Assert.assertEquals(reservaReprod.getNivel(), 0);
	}
}
