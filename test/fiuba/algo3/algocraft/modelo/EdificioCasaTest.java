package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;

public class EdificioCasaTest {

	@Test (expected = ErrorEdificioEnConstruccion.class)
	public void test01_UnaBarracaNoPuedeCrearUnidadesSiNoTerminoDeConstruirse(){
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		
		barraca.crearMarine();
	}
	
	@Test
	public void test02_UnaBarracaPuedeCrearUnidadesSiTerminoDeContruirse(){
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		for (int i=1; i <=12; i++){
			mapa.pasarTurno();
		}
		
		barraca.crearMarine();
		
		for (int i=1; i <=4; i++){
			mapa.pasarTurno();
		}
		
	}
	
	@Test
	public void test03_CrearUnDepositoDeSuministros(){
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		
		Assert.assertEquals(deposito.vidaActual(), 500);
		Assert.assertEquals(deposito.getCostoMineral(), 100);
		Assert.assertEquals(deposito.getCostoVespeno(), 0);
		Assert.assertEquals(deposito.getNivel(), 0);
	}
	
	@Test
	public void test04_CrearUnPilon(){
		Pilon pilon = new Pilon();
		
		Assert.assertEquals(pilon.vidaActual(), 600);
		//Assert.assertEquals(pilon.escudoActual(), 500);
		Assert.assertEquals(pilon.getCostoMineral(), 100);
		Assert.assertEquals(pilon.getCostoVespeno(), 0);
		Assert.assertEquals(pilon.getNivel(), 0);
	}
	
	@Test
	public void test05_CrearUnAmoSupremo(){
		AmoSupremo amo = new AmoSupremo();
		
		Assert.assertEquals(amo.vidaActual(), 700);
		Assert.assertEquals(amo.getCostoMineral(), 150);
		Assert.assertEquals(amo.getCostoVespeno(), 0);
		Assert.assertEquals(amo.getNivel(), 0);
	}

}
