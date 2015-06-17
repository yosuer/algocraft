package fiuba.algo3.algocraft.modelo.unidades;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Tierra;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;
import fiuba.algo3.algocraft.modelo.edificios.ReservaDeReproduccion;
import fiuba.algo3.algocraft.modelo.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.unidades.Golliat;
import fiuba.algo3.algocraft.modelo.unidades.Marine;
import fiuba.algo3.algocraft.modelo.unidades.Zealot;
import fiuba.algo3.algocraft.modelo.unidades.Zerling;

public class UnidadesTerrestresTest {

	@Test
	public void test00_PasarTurnoMarine() {
		Mapa mapa = new Mapa();
		
		Marine marine = new Marine();
		mapa.agregarElemento(2, 2, marine);
		
		mapa.pasarTurnoMapa();
	}
	
	@Test
	public void test01_CrearMarine() {
		Mapa mapa = new Mapa();
		mapa.aumentarPoblacion(50);
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa();
		
		barraca.crearMarine();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		Assert.assertEquals(mapa.getElemento(1, 2, 0),new Tierra());
		mapa.pasarTurnoMapa(); //en el cuarto turno se muestra xk tarda 3 turnos
		mapa.pasarTurnoMapa();
		Assert.assertNotNull(mapa.getElemento(1, 2, 0));
		Marine marine = (Marine) mapa.getElemento(1, 2, 0);
		Assert.assertEquals(marine.vidaActual(),40);
		Assert.assertEquals(marine.getCostoMineral(),50);
		Assert.assertEquals(marine.getCostoVespeno(),0);
	}
	
	@Test
	public void test03_CrearZealot() {
		Mapa mapa = new Mapa();
		mapa.aumentarPoblacion(50);
		Acceso acceso = new Acceso();
		mapa.recibirMineral(500);
		mapa.recibirVespeno(500);
		
		mapa.agregarElemento(1, 1, acceso);
		for (int i=1; i <=8; i++) mapa.pasarTurnoMapa();
		
		acceso.crearZealot();
		for (int i=1; i <=4; i++) mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		
		Assert.assertEquals(7,0, mapa.getPoblacionTotal());
		Zealot zealot = (Zealot) mapa.getElemento(1, 2, 0);
		Assert.assertEquals(zealot.vidaActual(),160);
		Assert.assertEquals(zealot.escudoRestante(),60);
		Assert.assertEquals(zealot.escudoRestante(), 60);
		Assert.assertEquals(zealot.getCostoMineral(),100);
		Assert.assertEquals(zealot.getCostoVespeno(),0);
	}
	
	@Test
	public void test04_crearDragon() {
		Mapa mapa = new Mapa();
		mapa.aumentarPoblacion(50);
		mapa.recibirMineral(500);
		mapa.recibirVespeno(500);
		
		Acceso acceso = new Acceso();
		mapa.agregarElemento(1, 1, acceso);
		for (int i=1; i <=8; i++) mapa.pasarTurnoMapa();
		
		acceso.crearDragon();
		for (int i=1; i <=6; i++) mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		
		Assert.assertEquals(7,0, mapa.getPoblacionTotal());
		Dragon dragon = (Dragon) mapa.getElemento(1, 2, 0);
		Assert.assertEquals(dragon.vidaActual(),180);
		Assert.assertEquals(dragon.escudoRestante(),80);
		Assert.assertEquals(dragon.getCostoMineral(),125);
		Assert.assertEquals(dragon.getCostoVespeno(),50);
	}
	
	@Test
	public void test05_CrearZerling() {
		Mapa mapa = new Mapa();
		mapa.aumentarPoblacion(50);
		ReservaDeReproduccion reserva = new ReservaDeReproduccion();
		mapa.agregarElemento(1, 1, reserva);
		for (int i=1; i <=10; i++) mapa.pasarTurnoMapa();
		
		mapa.pasarTurnoMapa();
		
		reserva.evolucionarLarva();
		for (int i=1; i <=6; i++) mapa.pasarTurnoMapa();
		
		Assert.assertEquals(9,5, mapa.getPoblacionTotal());
		Zerling zerling = (Zerling) mapa.getElemento(1, 2, 0);
		Assert.assertEquals(zerling.vidaActual(),35);
		Assert.assertEquals(zerling.getCostoMineral(),25);
		Assert.assertEquals(zerling.getCostoVespeno(),0);
	}
	
	@Test
	public void test06_CrearGolliat() {
		Mapa mapa = new Mapa();
		mapa.aumentarPoblacion(10);
		mapa.recibirMineral(1000);
		mapa.recibirVespeno(1000); //para pruebas aumento directamente
		
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa(); //barraca creada
		Fabrica fabrica = new Fabrica();
		mapa.agregarElemento(3, 3, fabrica);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa(); //fabrica creada
		
		fabrica.crearGolliat();	
		for (int i=1; i <=7; i++) mapa.pasarTurnoMapa();

		Assert.assertEquals(8,0, mapa.getPoblacionTotal());
		Golliat golliat = (Golliat) mapa.getElemento(3, 4, 0);
		Assert.assertEquals(golliat.vidaActual(),125);
		Assert.assertEquals(golliat.getCostoMineral(),100);
		Assert.assertEquals(golliat.getCostoVespeno(),50);
	}
	
	@Test
	public void test06_CreacionDeMarineYGoliat() {
		Mapa mapa = new Mapa();
		mapa.aumentarPoblacion(10);
		mapa.recibirMineral(1000);
		mapa.recibirVespeno(1000); //para pruebas aumento directamente
		
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		Fabrica fabrica = new Fabrica();
		mapa.agregarElemento(3, 3, fabrica);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa(); //fabrica y barraca creada
		
		fabrica.crearGolliat();	
		barraca.crearMarine();
		for (int i=1; i <=7; i++) mapa.pasarTurnoMapa();

		Assert.assertEquals(7,0, mapa.getPoblacionTotal());
		Golliat golliat = (Golliat) mapa.getElemento(3, 4, 0);
		Assert.assertEquals(golliat.vidaActual(),125);
		Assert.assertEquals(golliat.getCostoMineral(),100);
		Assert.assertEquals(golliat.getCostoVespeno(),50);
	}
	


}
