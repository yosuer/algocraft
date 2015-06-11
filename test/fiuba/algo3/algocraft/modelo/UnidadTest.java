package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {

	@Test
	public void CrearMarine() {
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		
		for (int i=1; i <=12; i++){
			mapa.pasarTurnoMapa();
		}
		
		barraca.crearMarine();
		
		for (int i=1; i <=5; i++){
			mapa.pasarTurnoMapa();
		}
		
		Marine marine = (Marine) mapa.getElemento(2, 2, 0);
		Assert.assertEquals(marine.vidaActual(),40);
		Assert.assertEquals(marine.getCostoMineral(),50);
		Assert.assertEquals(marine.getCostoVespeno(),0);
	}
	
	@Test
	public void PasarTurnoMarine() {
		Mapa mapa = new Mapa();
		Marine marine = new Marine();
		
		//mapa.agregarElemento(2, 2, marine);
		
		mapa.pasarTurnoMapa();
	}
//	
//	@Test
//	public void CrearZealot() {
//		Mapa mapa = new Mapa();
//		Acceso acceso = new Acceso();
//		mapa.agregarElemento(1, 1, acceso);
//		for (int i=1; i <=12; i++){
//			mapa.pasarTurno();
//		}
//		
//		Unidad zealot = acceso.crearZealot();
//		
//		Assert.assertEquals(zealot.vidaActual(),100);
//	}
//	
//	@Test
//	public void CrearZerling() {
//		Mapa mapa = new Mapa();
//		
//		ReservaDeReproduccion reserva = new ReservaDeReproduccion();
//		Unidad zerling = reserva.Zerling();
//		
//		Assert.assertEquals(zerling.vidaActual(),35);
//	}

}
