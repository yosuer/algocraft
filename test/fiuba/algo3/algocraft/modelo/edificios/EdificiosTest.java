package fiuba.algo3.algocraft.modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.Pilon;
import fiuba.algo3.algocraft.modelo.unidades.AmoSupremo;

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
	public void test04_CrearUnPilon(){
		Mapa mapa = new Mapa();
		Pilon pilon = new Pilon();
		mapa.agregarElemento(1, 1, pilon);
		
		Assert.assertEquals(pilon.vidaActual(), 600);
		Assert.assertEquals(pilon.escudoRestante(), 300);
		Assert.assertEquals(pilon.getCostoMineral(), 100);
		Assert.assertEquals(pilon.getCostoVespeno(), 0);
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
		Assert.assertEquals(amo.getTiempoDeConstruccion(),4);
		Assert.assertEquals(amo.getNivel(), 1);
	}

}
