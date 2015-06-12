package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class EdificiosTest {

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
			mapa.pasarTurnoMapa();
		}

		barraca.crearMarine();
		
		for (int i=1; i <=4; i++){
			mapa.pasarTurnoMapa();
		}
		
	}
	
	@Test
	public void test03_CrearUnDepositoDeSuministros(){
		Mapa mapa = new Mapa();
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		mapa.agregarElemento(1, 1, deposito);
		
		Assert.assertEquals(deposito.vidaActual(), 500);
		Assert.assertEquals(deposito.getCostoMineral(), 100);
		Assert.assertEquals(deposito.getCostoVespeno(), 0);
		Assert.assertEquals(deposito.tiempoDeConstruccion,6);
		Assert.assertEquals(deposito.getNivel(), 0);
	}
	
	@Test
	public void test04_CrearUnPilon(){
		Mapa mapa = new Mapa();
		Pilon pilon = new Pilon();
		mapa.agregarElemento(1, 1, pilon);
		
		Assert.assertEquals(pilon.vidaActual(), 600);
		Assert.assertEquals(pilon.escudoRestante(), 300);
		Assert.assertEquals(pilon.getCostoMineral(), 100);
		Assert.assertEquals(pilon.getCostoVespeno(), 0);
		Assert.assertEquals(pilon.tiempoDeConstruccion,5);
		Assert.assertEquals(pilon.getNivel(), 0);
	}
	
	@Test
	public void test05_CrearUnAmoSupremo(){
		Mapa mapa = new Mapa();
		AmoSupremo amo = new AmoSupremo();
		mapa.agregarElemento(1, 1, amo);
		
		Assert.assertEquals(amo.vidaActual(), 200);
		Assert.assertEquals(amo.getCostoMineral(), 100);
		Assert.assertEquals(amo.getCostoVespeno(), 0);
		Assert.assertEquals(amo.tiempoDeConstruccion,4);
		Assert.assertEquals(amo.getNivel(), 0);
	}

}
