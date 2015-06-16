package fiuba.algo3.algocraft.modelo.edificios;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.ReservaDeReproduccion;

public class EdificioUnidadesBasicasTest {
	
	@Test
	public void test02_CrearUnaBarraca(){
		Barraca barraca = new Barraca();
		
		Assert.assertEquals(barraca.vidaActual(), 1000);
		Assert.assertEquals(barraca.getCostoMineral(), 150);
		Assert.assertEquals(barraca.getCostoVespeno(), 0);
		Assert.assertEquals(barraca.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnAcceso(){
		Acceso acceso = new Acceso();
		
		Assert.assertEquals(acceso.vidaActual(), 1000);
		Assert.assertEquals(acceso.escudoRestante(), 500);
		Assert.assertEquals(acceso.getCostoMineral(), 150);
		Assert.assertEquals(acceso.getCostoVespeno(), 0);
		Assert.assertEquals(acceso.getNivel(), 0);
	}
	
	@Test
	public void test04_CrearUnaReservaDeReproduccion(){
		ReservaDeReproduccion reservaReprod = new ReservaDeReproduccion();
		
		Assert.assertEquals(reservaReprod.vidaActual(), 1000);
		Assert.assertEquals(reservaReprod.getCostoMineral(), 150);
		Assert.assertEquals(reservaReprod.getCostoVespeno(), 0);
		Assert.assertEquals(reservaReprod.getNivel(), 0);
	}
	
	@Test
	public void test02_CrearUnaBarracaYAgregarlaAlMapa(){
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca();
		
		mapa.agregarElemento(3,3, barraca);

		Assert.assertEquals(barraca,mapa.getElemento(3, 3, 0));
	}
	
	@Test
	public void test02_CrearUnaBarracaYEncolarUnMarineYExpedirMarine(){
		Mapa mapa = new Mapa();
		mapa.aumentarPoblacion(10);
		Barraca barraca = new Barraca();
		mapa.agregarElemento(3,3, barraca);
		for (int i=1; i<=12; i++) mapa.pasarTurnoMapa();
		
		barraca.crearMarine();
		
		for (int i=1; i<=4; i++) mapa.pasarTurnoMapa();
		
		Assert.assertNotNull(mapa.getElemento(2, 2, 0));
	}
	
	@Test
	public void test02_CrearUnaBarracaYCrear5Marine(){
		Mapa mapa = new Mapa();
		mapa.recibirMineral(1000);
		mapa.aumentarPoblacion(10);

		Barraca barraca = new Barraca();
		mapa.agregarElemento(3,3, barraca);
		for (int i=1; i<=12; i++) mapa.pasarTurnoMapa();
		
		barraca.crearMarine();
		barraca.crearMarine();
		barraca.crearMarine();
		barraca.crearMarine();
		
		for (int i=1; i<=20; i++) mapa.pasarTurnoMapa();
		
		Assert.assertNotNull(mapa.getElemento(3, 4, 0));
		Assert.assertNotNull(mapa.getElemento(4, 3, 0));
		Assert.assertNotNull(mapa.getElemento(4, 4, 0));
		Assert.assertNotNull(mapa.getElemento(1, 1, 0));
		Assert.assertNotNull(mapa.getElemento(3, 3, 0)); //barraca
	}
}