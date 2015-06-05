package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.FabricaDeElementos;
import fiuba.algo3.algocraft.FabricaProtoss;
import fiuba.algo3.algocraft.FabricaTerran;
import fiuba.algo3.algocraft.Mineral;
import fiuba.algo3.algocraft.ObstaculoTerrestre;
import fiuba.algo3.algocraft.Vespeno;
import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.EdificioUnidadesBasicas;

public class MapaTest {
	
	@Test
	public void test01_CrearMapaDe100X100(){
		Mapa nuevoMapa = new Mapa();
		
		//Probar bordes
		Assert.assertEquals(nuevoMapa.getElemento(new Posicion(1,1)),null);
		Assert.assertEquals(nuevoMapa.getElemento(new Posicion(1,100)),null);
		Assert.assertEquals(nuevoMapa.getElemento(new Posicion(100,1)),null);
		Assert.assertEquals(nuevoMapa.getElemento(new Posicion(100,100)),null);
		
		Assert.assertEquals(nuevoMapa.ancho(), 100);
		Assert.assertEquals(nuevoMapa.alto(), 100);	
	}
	
	@Test
	public void test02_DefinirMineralesEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		Elemento mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(mineral);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1)),mineral);	
	}
	
	@Test
	public void test03_DefinirVespenoEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		Elemento vespeno = new Vespeno(new Posicion(1,1));
		
		mapa.agregar(vespeno);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1)),vespeno);	
	}
	
	@Test
	public void test04_DefinirEspaciosVaciosEnElMapa(){
		Mapa mapa = new Mapa();
		ObstaculoTerrestre obstaculoTerrestre = new ObstaculoTerrestre(new Posicion(1,1));
		
		mapa.agregar(obstaculoTerrestre);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1)),obstaculoTerrestre);
	}
	
	
	@Test
	public void test05_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorOtroRecurso(){
		Mapa mapa = new Mapa();
		Elemento vespeno = new Vespeno(new Posicion(1,1));
		Elemento mineral = new Mineral(new Posicion(1,1));
		
		mapa.agregar(vespeno);
		mapa.agregar(mineral);
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1)),vespeno);
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
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1)),obstaculoTerrestre);
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
		
		Assert.assertEquals(mapa.getElemento(new Posicion(1,1)),barraca);
		Assert.assertEquals(mapa.getElemento(new Posicion(1,2)),acceso);
	}
	
	@Test
	public void test08_CrearUnMapaConRecursosPredeterminados(){
		Mapa mapa = new Mapa();
		mapa.inicializarMapa();
		
		Assert.assertTrue(mapa.getElemento(new Posicion(2,6)).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(new Posicion(2,2)).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(new Posicion(6,2)).getClass() ==	Mineral.class);
		
		Assert.assertNull(mapa.getElemento(new Posicion(3,3)));

		Assert.assertTrue(mapa.getElemento(new Posicion(4,6)).getClass() == Vespeno.class);
		
		Assert.assertTrue(mapa.getElemento(new Posicion(99,99)).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(new Posicion(95,99)).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(new Posicion(99,95)).getClass() ==	Mineral.class);
		
		Assert.assertNull(mapa.getElemento(new Posicion(97,97)));

		Assert.assertTrue(mapa.getElemento(new Posicion(95,97)).getClass() == Vespeno.class);
	}
	
	/*
	@Test
	public void testxx_IngresarJugadorEnMapa(){
		
		
	}
	*/
}
