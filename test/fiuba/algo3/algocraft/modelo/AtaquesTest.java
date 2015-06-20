package fiuba.algo3.algocraft.modelo;


import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorNoSePuedeAtacarElemento;
import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.DepositoDeSuministros;
import fiuba.algo3.algocraft.modelo.natural.Mineral;
import fiuba.algo3.algocraft.modelo.unidades.AmoSupremo;
import fiuba.algo3.algocraft.modelo.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.unidades.Golliat;
import fiuba.algo3.algocraft.modelo.unidades.Marine;
import fiuba.algo3.algocraft.modelo.unidades.Zealot;
import fiuba.algo3.algocraft.modelo.unidades.Zerling;

public class AtaquesTest {
	
	@Test
	public void test01_AtaqueEntreUnidadesTerran(){
		Mapa mapa = new Mapa(40, 40);
		Marine marine = new Marine();
		Golliat golliat = new Golliat();
		mapa.agregarElemento(4, 4, marine);
		mapa.agregarElemento(6, 6, golliat);
		
		Assert.assertEquals(125,golliat.vidaActual());
		Assert.assertEquals(40,marine.vidaActual());
		
		marine.atacar(golliat);
		golliat.atacar(marine);
		
		Assert.assertEquals(119,golliat.vidaActual());
		Assert.assertEquals(28,marine.vidaActual());
	}
	
	@Test
	public void test02_AtaqueAUnEdificioTerran(){
		Mapa mapa = new Mapa(40, 40);
		Marine marine = new Marine();
		DepositoDeSuministros depo = new DepositoDeSuministros();
		mapa.agregarElemento(6, 6, marine);
		mapa.agregarElemento(9, 9, depo);
		
		Assert.assertEquals(500,depo.vidaActual());
		
		marine.atacar(depo);
		Assert.assertEquals(494,depo.vidaActual());
	}
	
	@Test
	public void test03_AtaqueAUnidadProtoss(){
		Mapa mapa = new Mapa(40, 40);
		Golliat golliat = new Golliat();
		Dragon dragon = new Dragon();
		mapa.agregarElemento(8, 8, golliat);
		mapa.agregarElemento(5, 5, dragon);
		
		Assert.assertEquals(180,dragon.vidaActual());
		Assert.assertEquals(80,dragon.escudoRestante());
		
		golliat.atacar(dragon);
		
		Assert.assertEquals(168,dragon.vidaActual());
		Assert.assertEquals(68,dragon.escudoRestante());
	}
	
	@Test
	public void test04_AtaqueAEdificioProtoss(){
		Mapa mapa = new Mapa(40, 40);
		Espectro espectro = new Espectro();
		Acceso acceso = new Acceso();
		mapa.agregarElemento(6, 6, espectro);
		mapa.agregarElemento(6, 6, acceso);
		
		Assert.assertEquals(1000,acceso.vidaActual());
		Assert.assertEquals(500,acceso.escudoRestante());
		
		espectro = (Espectro)mapa.getElemento(6, 6, 1);
		acceso = (Acceso)mapa.getElemento(6, 6, 0);
		espectro.atacar(acceso);
		
		Assert.assertEquals(992,acceso.vidaActual());
		Assert.assertEquals(492,acceso.escudoRestante());
	}

	@Test (expected = ErrorObjetivoFueraDelAlcance.class)
	public void test05_UnZealotNoPuedeAtacarUnaUnidadAerea(){
		Mapa mapa = new Mapa(40, 40);
		Zealot zealot = new Zealot();
		Espectro espectro = new Espectro();
		mapa.agregarElemento(6, 6, espectro);
		mapa.agregarElemento(6, 6, zealot);
		
		zealot.atacar(espectro);
	}
	
	@Test (expected = ErrorObjetivoFueraDelAlcance.class)
	public void test06_UnZerlingNoPuedeAtacarUnaUnidadAerea(){
		Mapa mapa = new Mapa(40, 40);
		Zerling zerling = new Zerling();
		Espectro espectro = new Espectro();
		mapa.agregarElemento(7, 7, espectro);
		mapa.agregarElemento(6, 6, zerling);
		
		zerling.atacar(espectro);
	}
	
	@Test (expected = ErrorObjetivoFueraDelAlcance.class)
	public void test07_EspectroNoPuedeAtacarAUnDaniableFueraDelAlcance(){
		Mapa mapa = new Mapa(40, 40);
		Espectro espectro = new Espectro();
		Acceso acceso = new Acceso();
		
		mapa.agregarElemento(6, 6, espectro);
		mapa.agregarElemento(10, 10, acceso);
		
		espectro.atacar(acceso);
	}
	
	@Test (expected = ErrorObjetivoFueraDelAlcance.class)
	public void test08_GolliatNoPuedeAtacarAUnDaniableFueraDelAlcance(){
		Mapa mapa = new Mapa(40, 40);
		Golliat golliat = new Golliat();
		Barraca barraca = new Barraca();
		
		mapa.agregarElemento(6, 6, golliat);
		mapa.agregarElemento(11, 11, barraca);
		
		golliat.atacar(barraca);
	}
	
	@Test (expected = ErrorObjetivoFueraDelAlcance.class)
	public void test09_DragonNoPuedeAtacarAUnDaniableFueraDelAlcance(){
		Mapa mapa = new Mapa(40, 40);
		Dragon dragon = new Dragon();
		AmoSupremo amoSupremo = new AmoSupremo();
		
		mapa.agregarElemento(6, 6, dragon);
		mapa.agregarElemento(11, 11, amoSupremo);
		
		dragon.atacar(amoSupremo);
	}
	
	@Test
	public void test10_RangoDeAlcanceEspectro(){
		Mapa mapa = new Mapa(40, 40);
		Espectro espectro = new Espectro();
		Acceso acceso = new Acceso();
		Marine marine = new Marine();
		
		mapa.agregarElemento(6, 6, espectro);
		mapa.agregarElemento(7, 7, marine);
		mapa.agregarElemento(12, 12, acceso);
		
		Assert.assertEquals(1000,acceso.vidaActual());
		Assert.assertEquals(500,acceso.escudoRestante());
		Assert.assertEquals(40,marine.vidaActual());
		try {
			espectro.atacar(acceso);
		} catch (ErrorObjetivoFueraDelAlcance e){
		}
		
		espectro.atacar(marine);
		
		Assert.assertEquals(1000,acceso.vidaActual());
		Assert.assertEquals(500,acceso.escudoRestante());
		Assert.assertEquals(32,marine.vidaActual());
	}
	
	@Test
	public void test11_RangoDeAlcanceZealot(){
		Mapa mapa = new Mapa(40, 40);
		Mineral mineral = new Mineral();
		Espectro espectro = new Espectro();
		CentroDeMineral centroMineral = new CentroDeMineral();
		Marine marine = new Marine();
		Zealot zealot = new Zealot();
		
		mapa.agregarElemento(9, 8, mineral);
		mapa.agregarElemento(8, 8, espectro);
		mapa.agregarElemento(7, 7, marine);
		mapa.agregarElemento(8, 8, zealot);
		mapa.agregarElemento(9, 8, centroMineral);
		
		Assert.assertEquals(500,centroMineral.vidaActual());
		Assert.assertEquals(120,espectro.vidaActual());
		Assert.assertEquals(40,marine.vidaActual());
		try {
			zealot.atacar(espectro);
		} catch (ErrorObjetivoFueraDelAlcance e){
		}
		
		zealot.atacar(marine);
		zealot.atacar(centroMineral);
		
		Assert.assertEquals(120,espectro.vidaActual());
		Assert.assertEquals(492,centroMineral.vidaActual());
		Assert.assertEquals(32,marine.vidaActual());
	}

	
}
