package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

public class MapaTest {
	
	@Test
	public void test01_CrearMapaDe100X100(){
		Mapa nuevoMapa = new Mapa();
		
		//Probar bordes
		Assert.assertEquals(nuevoMapa.elemento(new Posicion(1,1)),null);
		Assert.assertEquals(nuevoMapa.elemento(new Posicion(1,100)),null);
		Assert.assertEquals(nuevoMapa.elemento(new Posicion(100,1)),null);
		Assert.assertEquals(nuevoMapa.elemento(new Posicion(100,100)),null);
		
		Assert.assertEquals(nuevoMapa.ancho(), 100);
		Assert.assertEquals(nuevoMapa.alto(), 100);	
	}
	
	@Test
	public void test02_DefinirMineralesEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		Elemento mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(mineral);
		
		Assert.assertEquals(mapa.elemento(new Posicion(1,1)),mineral);	
	}
	
	@Test
	public void test03_DefinirVespenoEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		Elemento vespeno = new Vespeno(new Posicion(1,1));
		
		mapa.agregar(vespeno);
		
		Assert.assertEquals(mapa.elemento(new Posicion(1,1)),vespeno);	
	}
	
	@Test
	public void test04_DefinirEspaciosVaciosEnElMapa(){
		Mapa mapa = new Mapa();
		ObstaculoTerrestre obstaculoTerrestre = new ObstaculoTerrestre(new Posicion(1,1));
		
		mapa.agregar(obstaculoTerrestre);
		
		Assert.assertEquals(mapa.elemento(new Posicion(1,1)),obstaculoTerrestre);
	}
	
	
	@Test
	public void test05_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorOtroRecurso(){
		Mapa mapa = new Mapa();
		Elemento vespeno = new Vespeno(new Posicion(1,1));
		Elemento mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(vespeno);
		mapa.agregar(mineral);
		
		Assert.assertEquals(mapa.elemento(new Posicion(1,1)),vespeno);
	}
	
	
	@Test
	public void test06_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorObstaculoTerrestre(){
		Mapa mapa = new Mapa();
		
		ObstaculoTerrestre obstaculoTerrestre = new ObstaculoTerrestre(new Posicion(1,1));
		Elemento vespeno = new Vespeno(new Posicion(1,1));
		Elemento mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(obstaculoTerrestre);
		mapa.agregar(vespeno);
		mapa.agregar(mineral);
		
		Assert.assertEquals(mapa.elemento(new Posicion(1,1)),obstaculoTerrestre);
	}
	
	@Test
	public void test07_AgregarFabricasUnidadesBasicasAlMapa(){
		Mapa mapa = new Mapa();
		FabricaDeElementos fabricaProtoss = new FabricaProtoss();
		FabricaDeElementos fabricaTerran = new FabricaTerran();
		FabricaUnidadesBasicas barraca = fabricaTerran.crearFabricaUnidadesBasicas(new Posicion(1,1));
		FabricaUnidadesBasicas acceso = fabricaProtoss.crearFabricaUnidadesBasicas(new Posicion(1,2));
		mapa.agregar(barraca);
		mapa.agregar(acceso);
		
		Assert.assertEquals(mapa.elemento(new Posicion(1,1)),barraca);
		Assert.assertEquals(mapa.elemento(new Posicion(1,2)),acceso);
	}
	
	
	/*
	@Test
	public void testxx_IngresarJugadorEnMapa(){
		
		
	}
	*/
}
