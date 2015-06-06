package fiuba.algo3.algocraft.modelo;

import org.junit.Test;

public class UnidadTest {

	@Test
	public void CrearMarine() {
		Mapa mapa = new Mapa();
		
		Barraca barraca = new Barraca(mapa);
		Marine marine= barraca.crearUnidad();
		
		Assert.assertEquals(marine.vida(),40);
		Assert.assertEquals(marine.(),40);
	}

}
