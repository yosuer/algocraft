package fiuba.algo3.ejemplo1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaTest {
	
	@Test
	public void test01_CrearMapaDe100X100(){
		Mapa nuevoMapa = new Mapa();
		
		assertEquals(nuevoMapa.ancho(), 100);
		assertEquals(nuevoMapa.alto(), 100);	
	}
	
	@Test
	public void test02_DefinirMineralesEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(mineral);
		
		assertEquals(mapa.elemento(new Posicion(1,1)),mineral);	
	}
	
	@Test
	public void test03_DefinirVespenoEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		
		mapa.agregar(vespeno);
		
		assertEquals(mapa.elemento(new Posicion(1,1)),vespeno);	
	}
	
	@Test
	public void test04_DefinirEspaciosVaciosEnElMapa(){
		Mapa mapa = new Mapa();
		ObstaculoTerrestre obstaculoTerrestre = new ObstaculoTerrestre(new Posicion(1,1));
		
		mapa.agregar(obstaculoTerrestre);
		
		assertEquals(mapa.elemento(new Posicion(1,1)),obstaculoTerrestre);
	}
	
	
	@Test
	public void test05_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorOtroRecurso(){
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		Recurso mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(vespeno);
		mapa.agregar(mineral);
		
		assertEquals(mapa.elemento(new Posicion(1,1)),vespeno);
	}
	
	@Test
	public void test06_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorObstaculoTerrestre(){
		Mapa mapa = new Mapa();
		
		ObstaculoTerrestre obstaculoTerrestre = new ObstaculoTerrestre(new Posicion(1,1));
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		Recurso mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(obstaculoTerrestre);
		mapa.agregar(vespeno);
		mapa.agregar(mineral);
		
		assertEquals(mapa.elemento(new Posicion(1,1)),obstaculoTerrestre);
	}
	
//	@Test
//	public void test07_CrearEdificio(){
//		Mapa mapa = new Mapa();
//		FabricaTerran fabricaTerran;
//		FabricaUnidadesBasicas barraca = fabricaTerran.crearFabricaUnidadesBasicas(new Posicion(1,1));
//		
//		mapa.agregar(barraca);
//		
//		assertEquals(mapa.elemento(new Posicion(1,1)),barraca);
//	}
	
	@Test
	public void testXX_IngresarJugadorEnMapa(){	
		//Interface elemento como cualquier objeto que sea parte del mapa del juego
	}

}
