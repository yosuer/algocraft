package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class UnidadTest {

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
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa();
		
		barraca.crearMarine();
		for (int i=1; i <=3; i++) mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa(); //en el cuarto turno se muestra xk tarda 3 turnos
		
		Marine marine = (Marine) mapa.getElemento(2, 2, 0);
		Assert.assertEquals(marine.vidaActual(),40);
		Assert.assertEquals(marine.getCostoMineral(),50);
		Assert.assertEquals(marine.getCostoVespeno(),0);
	}
	
	@Test
	public void test03_CrearZealot() {
		Mapa mapa = new Mapa();
		Acceso acceso = new Acceso();
		mapa.agregarElemento(1, 1, acceso);
		for (int i=1; i <=8; i++) mapa.pasarTurnoMapa();
		
		acceso.crearZealot();
		for (int i=1; i <=4; i++) mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		
		Zealot zealot = (Zealot) mapa.getElemento(2, 2, 0);
		Assert.assertEquals(zealot.vidaActual(),160);
		Assert.assertEquals(zealot.escudoRestante(),60);
		Assert.assertEquals(zealot.escudoRestante(), 60);
		Assert.assertEquals(zealot.getCostoMineral(),100);
		Assert.assertEquals(zealot.getCostoVespeno(),0);
	}
	
	@Test
	public void test04_crearDragon() {
		Mapa mapa = new Mapa();
		Acceso acceso = new Acceso();
		mapa.agregarElemento(1, 1, acceso);
		for (int i=1; i <=8; i++) mapa.pasarTurnoMapa();
		
		acceso.crearDragon();
		for (int i=1; i <=6; i++) mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		
		Dragon dragon = (Dragon) mapa.getElemento(2, 2, 0);
		Assert.assertEquals(dragon.vidaActual(),180);
		Assert.assertEquals(dragon.escudoRestante(),80);
		Assert.assertEquals(dragon.getCostoMineral(),125);
		Assert.assertEquals(dragon.getCostoVespeno(),50);
	}
	
	@Test
	public void test05_CrearZerling() {
		Mapa mapa = new Mapa();
		ReservaDeReproduccion reserva = new ReservaDeReproduccion();
		mapa.agregarElemento(1, 1, reserva);
		for (int i=1; i <=10; i++) mapa.pasarTurnoMapa();
		
		reserva.evolucionarLarva();
		for (int i=1; i <=6; i++) mapa.pasarTurnoMapa();
		
		Zerling zerling = (Zerling) mapa.getElemento(2, 2, 0);
		Assert.assertEquals(zerling.vidaActual(),35);
		Assert.assertEquals(zerling.getCostoMineral(),25);
		Assert.assertEquals(zerling.getCostoVespeno(),0);
	}
	
	@Test
	public void test06_CrearGolliat() {
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa(); //barraca creada
		Fabrica fabrica = new Fabrica();
		mapa.agregarElemento(3, 3, fabrica);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa(); //fabrica creada
		
		fabrica.crearGolliat();	
		for (int i=1; i <=7; i++) mapa.pasarTurnoMapa();

		Golliat golliat = (Golliat) mapa.getElemento(2, 2, 0);
		Assert.assertEquals(golliat.vidaActual(),125);
		Assert.assertEquals(golliat.getCostoMineral(),100);
		Assert.assertEquals(golliat.getCostoVespeno(),50);
	}
	
	@Test
	public void test06_CreacionDeMarineYGoliat() {
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca();
		mapa.agregarElemento(1, 1, barraca);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa(); //barraca creada
		Fabrica fabrica = new Fabrica();
		mapa.agregarElemento(3, 3, fabrica);
		for (int i=1; i <=12; i++) mapa.pasarTurnoMapa(); //fabrica creada
		
		fabrica.crearGolliat();	
		for (int i=1; i <=7; i++) mapa.pasarTurnoMapa();

		Golliat golliat = (Golliat) mapa.getElemento(2, 2, 0);
		Assert.assertEquals(golliat.vidaActual(),125);
		Assert.assertEquals(golliat.getCostoMineral(),100);
		Assert.assertEquals(golliat.getCostoVespeno(),50);
	}
	


}
