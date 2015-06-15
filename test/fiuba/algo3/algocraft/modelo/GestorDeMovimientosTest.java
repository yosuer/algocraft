package fiuba.algo3.algocraft.modelo;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class GestorDeMovimientosTest {
	
	@Test
	public void test01_ObtenerCaminos(){
		GestorDeUbicaciones gm = new GestorDeUbicaciones(10,10,1);
		Posicion inicio = new Posicion(1,1,0);
		Posicion destino = new Posicion(6,6,0);
		
		Collection<Posicion> camino = gm.getHojaDeRuta(inicio, destino);
		
		Assert.assertEquals(6, camino.size());
	}

}
