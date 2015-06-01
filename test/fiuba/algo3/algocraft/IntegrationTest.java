package fiuba.algo3.algocraft;

import org.junit.Test;

public class IntegrationTest {
	
	@Test
	public void test_CrearUnMapaConMineralesGasVespenoYObstaculosTerrestres(){
		Mapa mapa = new Mapa();
		
		mapa.agregar(new Mineral(new Posicion(2,2)));
		
	}
}
