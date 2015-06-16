package fiuba.algo3.algocraft.modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.edificios.Pilon;

public class PilonTest {

	@Test
	public void test01_PilonAumentaPoblacionAlConstruirse(){
		Mapa mapa = new Mapa();
		Pilon pilon = new Pilon();
		
		mapa.agregarElemento(3, 3, pilon);
		Assert.assertEquals(0,0,mapa.getPoblacionTotal());
		
		mapa.pasarTurnoMapa();	
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa(); 
		mapa.pasarTurnoMapa(); 
		Assert.assertEquals(0,0,mapa.getPoblacionTotal());
		
		mapa.pasarTurnoMapa();
		Assert.assertEquals(5,0,mapa.getPoblacionTotal());
	}
}
