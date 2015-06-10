package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Grafo.Nodo;

public class MapaTest {
	
	@Test
	public void test01_CrearMapaConTierraDe100X100(){
		Mapa nuevoMapa = new Mapa();
		
		Assert.assertEquals(nuevoMapa.ancho(), 100);
		Assert.assertEquals(nuevoMapa.largo(), 100);	
		Assert.assertEquals(nuevoMapa.alto(), 2);	
	}
	
	@Test
	public void test02_DefinirMineralesEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		IElemento mineral = new Mineral();
		
		mapa.agregarElemento(1,1,mineral);
		
		Assert.assertEquals(mapa.getElemento(1,1,0),mineral);	
	}
	
	@Test
	public void test03_DefinirVespenoEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		IElemento vespeno = new Vespeno();
		
		mapa.agregarElemento(1,1,vespeno);
		
		Assert.assertEquals(mapa.getElemento(1,1,0),vespeno);	
	}
	
	@Test
	public void test04_DefinirEspaciosVaciosEnElMapa(){
		Mapa mapa = new Mapa();
		ObstaculoTerrestre obstaculoTerrestre = 
									new ObstaculoTerrestre();
		
		mapa.agregarElemento(2,2,obstaculoTerrestre);
		
		Assert.assertEquals(mapa.getElemento(2,2,0),obstaculoTerrestre);
	}
	
	
	@Test(expected = ErrorPosicionOcupada.class)
	public void test05_AgregarUnRecursoEnUnaPosicionOcupadaLanzaError(){
		Mapa mapa = new Mapa();
		IElemento vespeno = new Vespeno();
		IElemento mineral = new Mineral();
		mapa.agregarElemento(1,1,vespeno);
		mapa.agregarElemento(1,1,mineral);
	}
	
	@Test
	public void test05_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorOtroRecurso(){
		Mapa mapa = new Mapa();
		IElemento mineral = new Mineral();
		IElemento vespeno = new Vespeno();
		mapa.agregarElemento(1,1,mineral);
		try {
			mapa.agregarElemento(1,1,vespeno);
		} catch (ErrorPosicionOcupada e){
		}
		
		Assert.assertEquals(mapa.getElemento(1,1,0),mineral);
	}
	
	
	@Test
	public void test06_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorObstaculoTerrestre(){
		Mapa mapa = new Mapa();
		ObstaculoTerrestre obstaculo = new ObstaculoTerrestre();
		IElemento vespeno = new Vespeno();
		IElemento mineral = new Mineral();
		
		mapa.agregarElemento(4,4,obstaculo);
		
		try {
			mapa.agregarElemento(4,4,vespeno);
			mapa.agregarElemento(4,4,mineral);
		} catch (ErrorPosicionOcupada e){
		}
		
		Assert.assertEquals(mapa.getElemento(4,4,0),obstaculo);
	}
	
//	@Test
//	public void test07_AgregarFabricasUnidadesBasicasAlMapa(){
//		Mapa mapa = new Mapa();
//		FabricaDeElementos fabricaProtoss = new FabricaProtoss();
//		FabricaDeElementos fabricaTerran = new FabricaTerran();
//		EdificioUnidadesBasicas barraca = 
//					fabricaTerran.crearFabricaUnidadesBasicas();
//		EdificioUnidadesBasicas acceso = fabricaProtoss.crearFabricaUnidadesBasicas();
//		mapa.agregarElemento(1,1,barraca);
//		mapa.agregarElemento(1,2,acceso);
//		
//		Assert.assertEquals(mapa.getElemento(1,1,0),barraca);
//		Assert.assertEquals(mapa.getElemento(1,2,0),acceso);
//	}
	
	@Test
	public void test08_CrearUnMapaConRecursosPredeterminados(){
		Mapa mapa = new Mapa();
		mapa.inicializarMapa();
		
		Assert.assertTrue(mapa.getElemento(2,6, 0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(2,2, 0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(6,2, 0).getClass() ==	Mineral.class);
		
		Assert.assertNull(mapa.getElemento(3,3, 0));

		Assert.assertTrue(mapa.getElemento(4,6, 0).getClass() == Vespeno.class);
		
		Assert.assertTrue(mapa.getElemento(99,99,0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(95,99,0).getClass() ==	Mineral.class);
		Assert.assertTrue(mapa.getElemento(99,95,0).getClass() ==	Mineral.class);
		
		Assert.assertNull(mapa.getElemento(97,97,0));

		Assert.assertTrue(mapa.getElemento(95,97,0).getClass() == Vespeno.class);
	}
	
	@Test
	public void test09_AlIniciarElMapaSePuedeRecorrerTodasLasPosiciones1(){
		Mapa mapa = new Mapa();
		
		ArrayList<Posicion>camino = 
			(ArrayList<Posicion>) mapa.getHojaDeRuta(new Posicion(1,1,0), new Posicion(4,4,0));
		
		Assert.assertEquals(4, camino.size());
		
		ArrayList<Posicion> caminoEsperado = new ArrayList<Posicion>();
		caminoEsperado.add(new Posicion(1,1,0));
		caminoEsperado.add(new Posicion(2,2,0));
		caminoEsperado.add(new Posicion(3,3,0));
		caminoEsperado.add(new Posicion(4,4,0));
		
		Assert.assertEquals(caminoEsperado, camino);
	}

	@Test
	public void test09_AlIniciarElMapaSePuedeRecorrerTodasLasPosiciones2(){
		Mapa mapa = new Mapa();
		
		ArrayList<Posicion>camino = 
			(ArrayList<Posicion>) mapa.getHojaDeRuta(new Posicion(100,100,0), new Posicion(80,80,0));
		
		Assert.assertEquals(21, camino.size());
	}
	
	@Test
	public void test09_CaminoMinimoConElementosEnElMapa(){
		Mapa mapa = new Mapa();
		
		//mapa.agregarElemento(1, 2, new ObstaculoTerrestre());
		mapa.agregarElemento(2, 2, new ObstaculoTerrestre());
		
		ArrayList<Posicion>camino = 
			(ArrayList<Posicion>) mapa.getHojaDeRuta(new Posicion(1,3,0), 
													 new Posicion(3,1,0));
		
		Iterator<Posicion> it = camino.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
		Assert.assertEquals(4, camino.size());
	}
	
//	@Test
//	public void testNoSePuedeMoverUnEdificio(){
//		Mapa mapa = new Mapa();
//		Barraca barraca = new Barraca();
//		mapa.agregarElemento(4, 4, barraca);
//		
//		mapa.moverElemento(barraca,7,7);
//		
//		Assert.assertEquals(mapa.getElemento(4,4,0),barraca);
//		Assert.assertEquals(mapa.getElemento(7,7,0),null);
//	}
	
	/*
	@Test
	public void testxx_IngresarJugadorEnMapa(){
		
		
	}
	*/
}
