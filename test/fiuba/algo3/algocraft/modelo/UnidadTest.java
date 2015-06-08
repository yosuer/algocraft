package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {

	@Test
	public void CrearMarine() {
		Mapa mapa = new Mapa();
		
		Barraca barraca = new Barraca(mapa);
		Unidad marine = barraca.crearUnidad();
		
		Assert.assertEquals(marine.vidaActual(),40);
		Assert.assertEquals(marine.getCostoMineral(),50);
		Assert.assertEquals(marine.getCostoVespeno(),0);
	}
	
	@Test
	public void CrearZealot() {
		Mapa mapa = new Mapa();
		
		Acceso acceso = new Acceso(mapa);
		Unidad zealot = acceso.crearUnidad();
		
		Assert.assertEquals(zealot.vidaActual(),100);
	}
	
	@Test
	public void CrearZerling() {
		Mapa mapa = new Mapa();
		
		ReservaDeReproduccion reserva = new ReservaDeReproduccion(mapa);
		Unidad zerling = reserva.crearUnidad();
		
		Assert.assertEquals(zerling.vidaActual(),35);
	}

}
