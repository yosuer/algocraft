package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {

	@Test
	public void CrearMarine() {
		Mapa mapa = new Mapa();
		
		Barraca barraca = new Barraca(mapa);
		Unidad marine= barraca.crearUnidad();
		
//		Assert.assertEquals(marine.vidaActual(),40);
	}

}
