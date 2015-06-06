package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;

public class MapaTest {
	
	@Test
	public void test01_CrearMapaDe100X100(){
		Mapa nuevoMapa = new Mapa();
		
		//Probar bordes
		Assert.assertEquals(nuevoMapa.getElemento(new Posicion(1,1), 0),null);
		Assert.assertEquals(nuevoMapa.getElemento(new Posicion(1,100), 0),null);
		Assert.assertEquals(nuevoMapa.getElemento(new Posicion(100,1), 0),null);
		Assert.assertEquals(nuevoMapa.getElemento(new Posicion(100,100), 0),null);
		
		Assert.assertEquals(nuevoMapa.ancho(), 100);
		Assert.assertEquals(nuevoMapa.alto(), 100);	
	}
	
	@Test
	public void test02_DefinirMineralesEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		Elemento mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(mineral);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1),0),mineral);	
	}
	
	@Test
	public void test03_DefinirVespenoEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		Elemento vespeno = new Vespeno(new Posicion(1,1));
		
		mapa.agregar(vespeno);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1), 0),vespeno);	
	}
	
	@Test
	public void test04_DefinirEspaciosVaciosEnElMapa(){
		Mapa mapa = new Mapa();
		ObstaculoTerrestre obstaculoTerrestre = new ObstaculoTerrestre(new Posicion(1,1));
		
		mapa.agregar(obstaculoTerrestre);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1), 0),obstaculoTerrestre);
	}
	
	
	@Test
	public void test05_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorOtroRecurso(){
		Mapa mapa = new Mapa();
		Elemento vespeno = new Vespeno(new Posicion(1,1));
		Elemento mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(vespeno);
		mapa.agregar(mineral);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1), 0),vespeno);
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
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1), 0),obstaculoTerrestre);
	}
	
	@Test
	public void test07_AgregarFabricasUnidadesBasicasAlMapa(){
		Mapa mapa = new Mapa();
		FabricaDeElementos fabricaProtoss = new FabricaProtoss();
		FabricaDeElementos fabricaTerran = new FabricaTerran();
		EdificioUnidadesBasicas barraca = fabricaTerran.crearFabricaUnidadesBasicas(new Posicion(1,1));
		EdificioUnidadesBasicas acceso = fabricaProtoss.crearFabricaUnidadesBasicas(new Posicion(1,2));
		mapa.agregar(barraca);
		mapa.agregar(acceso);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1), 0),barraca);
		Assert.assertEquals(mapa.getElemento(new Posicion(1,2), 0),acceso);
	}
	
	@Test
	public void test08_CrearUnMapaConRecursosPredeterminados(){
		Mapa mapa = new Mapa();
		mapa.inicializarMapa();
		
		Assert.assertTrue(mapa.getElemento(new Posicion(2,6), 0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(new Posicion(2,2), 0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(new Posicion(6,2), 0).getClass() ==	Mineral.class);
		
		Assert.assertNull(mapa.getElemento(new Posicion(3,3), 0));

		Assert.assertTrue(mapa.getElemento(new Posicion(4,6), 0).getClass() == Vespeno.class);
		
		Assert.assertTrue(mapa.getElemento(new Posicion(99,99), 0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(new Posicion(95,99), 0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(new Posicion(99,95), 0).getClass() ==	Mineral.class);
		
		Assert.assertNull(mapa.getElemento(new Posicion(97,97), 0));

		Assert.assertTrue(mapa.getElemento(new Posicion(95,97), 0).getClass() == Vespeno.class);
	}
	
	/*
	@Test
	public void testxx_IngresarJugadorEnMapa(){
		
		
	}
	*/
}
