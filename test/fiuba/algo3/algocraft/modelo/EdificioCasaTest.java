package fiuba.algo3.algocraft.modelo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class EdificioCasaTest {

	@Test
	public void test01_CrearUnidadesYVerificarPropiedasBasicas(){
		
	}
	
	@Test
	public void test02_CrearUnDepositoDeSuministros(){
		Mapa mapa = new Mapa();
		DepositoDeSuministros deposito = new DepositoDeSuministros(mapa);
		
		Assert.assertEquals(deposito.vidaActual(), 500);
		Assert.assertEquals(deposito.getCostoMineral(), 100);
		Assert.assertEquals(deposito.getCostoVespeno(), 0);
		Assert.assertEquals(deposito.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnPilon(){
		Mapa mapa = new Mapa();
		
		Pilon pilon = new Pilon(mapa);
		
		Assert.assertEquals(pilon.vidaActual(), 600);
		//Assert.assertEquals(pilon.escudoActual(), 500);
		Assert.assertEquals(pilon.getCostoMineral(), 100);
		Assert.assertEquals(pilon.getCostoVespeno(), 0);
		Assert.assertEquals(pilon.getNivel(), 0);
	}
	
	@Test
	public void test04_CrearUnAmoSupremo(){
		Mapa mapa = new Mapa();
		AmoSupremo amo = new AmoSupremo(mapa);
		
		Assert.assertEquals(amo.vidaActual(), 700);
		Assert.assertEquals(amo.getCostoMineral(), 150);
		Assert.assertEquals(amo.getCostoVespeno(), 0);
		Assert.assertEquals(amo.getNivel(), 0);
	}

}
