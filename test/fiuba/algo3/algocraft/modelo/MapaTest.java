package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.natural.Mineral;
import fiuba.algo3.algocraft.modelo.natural.ObstaculoTerrestre;
import fiuba.algo3.algocraft.modelo.natural.Tierra;
import fiuba.algo3.algocraft.modelo.natural.Vespeno;
import fiuba.algo3.algocraft.modelo.unidades.Espectro;
import fiuba.algo3.algocraft.modelo.unidades.Marine;
import fiuba.algo3.algocraft.modelo.unidades.Zealot;

public class MapaTest {
	
	@Test
	public void test01_CrearMapaConTierraDe30X30(){
		Mapa nuevoMapa = new Mapa(30, 40);
		
		Assert.assertEquals(nuevoMapa.ancho(), 30);
		Assert.assertEquals(nuevoMapa.largo(), 40);	
		Assert.assertEquals(nuevoMapa.alto(), 1);	
	}
	
	@Test
	public void test02_DefinirMineralesEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa(40, 40);
		IElemento mineral = new Mineral();
		
		mapa.agregarElemento(1,1,mineral);
		
		Assert.assertEquals(mineral,mapa.getElemento(1,1,0));	
	}
	
	@Test
	public void test03_DefinirVespenoEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa(40, 40);
		IElemento vespeno = new Vespeno();
		
		mapa.agregarElemento(1,1,vespeno);
		
		Assert.assertEquals(mapa.getElemento(1,1,0),vespeno);	
	}
	
	@Test
	public void test04_DefinirEspaciosVaciosEnElMapa(){
		Mapa mapa = new Mapa(40, 40);
		ObstaculoTerrestre obstaculoTerrestre = 
									new ObstaculoTerrestre();
		
		mapa.agregarElemento(6,6,obstaculoTerrestre);
		
		Assert.assertEquals(mapa.getElemento(6,6,0),obstaculoTerrestre);
	}
	
	
	@Test(expected = ErrorPosicionOcupada.class)
	public void test05_AgregarUnRecursoEnUnaPosicionOcupadaLanzaError(){
		Mapa mapa = new Mapa(40, 40);
		IElemento vespeno = new Vespeno();
		IElemento mineral = new Mineral();
		mapa.agregarElemento(1,1,vespeno);
		mapa.agregarElemento(1,1,mineral);
	}
	
	@Test
	public void test06_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorOtroRecurso(){
		Mapa mapa = new Mapa(40, 40);
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
	public void test07_RecursoNoPuedeEstarEnUnaPosicionDelMapaOcupadaPorObstaculoTerrestre(){
		Mapa mapa = new Mapa(40, 40);
		ObstaculoTerrestre obstaculo = new ObstaculoTerrestre();
		IElemento vespeno = new Vespeno();
		IElemento mineral = new Mineral();
		
		mapa.agregarElemento(5,5,obstaculo);
		
		try {
			mapa.agregarElemento(5,5,vespeno);
			mapa.agregarElemento(5,5,mineral);
		} catch (ErrorPosicionOcupada e){
		}
		
		Assert.assertEquals(mapa.getElemento(5,5,0),obstaculo);
	}
	
	@Test
	public void test08_CrearUnMapaConRecursosPredeterminados(){
		Mapa mapa = new Mapa(50, 50);
		
		Assert.assertTrue(mapa.getElemento(2,6, 0).nombre() ==	"Mineral");
		Assert.assertTrue(mapa.getElemento(2,2, 0).nombre() ==	"Mineral");
		Assert.assertTrue(mapa.getElemento(6,2, 0).nombre() ==	"Mineral");
		
		Assert.assertEquals(mapa.getElemento(3,3, 0).nombre(), "Tierra");

		Assert.assertTrue(mapa.getElemento(4,6, 0).nombre() == "Vespeno");
		
		Assert.assertTrue(mapa.getElemento(45,49,0).nombre() ==	"Mineral");
		Assert.assertTrue(mapa.getElemento(49,49,0).nombre() ==	"Mineral");
		Assert.assertTrue(mapa.getElemento(49,45,0).nombre() ==	"Mineral");
		
		Assert.assertEquals(mapa.getElemento(47,47,0).nombre(), "Tierra");

		Assert.assertTrue(mapa.getElemento(47,45,0).nombre() == "Vespeno");
	}
	
	@Test
	public void test09_AlIniciarElMapaSePuedeRecorrerTodasLasPosiciones1(){
		Mapa mapa = new Mapa(40, 40);
		
		Collection<Posicion>camino = new ArrayList<Posicion>();
		camino = mapa.getHojaDeRuta(new Posicion(5,5,0),new Posicion(8,8,0));
		
		Assert.assertEquals(4, camino.size());
		
		ArrayList<Posicion> caminoEsperado = new ArrayList<Posicion>();
		caminoEsperado.add(new Posicion(5,5,0));
		caminoEsperado.add(new Posicion(6,6,0));
		caminoEsperado.add(new Posicion(7,7,0));
		caminoEsperado.add(new Posicion(8,8,0));
		
		Assert.assertEquals(caminoEsperado, camino);
	}

	@Test
	public void test10_AlIniciarElMapaSePuedeRecorrerTodasLasPosiciones2(){
		Mapa mapa = new Mapa(40, 40);
		
		Collection<Posicion>camino =mapa.getHojaDeRuta(new Posicion(5,5,0), new Posicion(7,7,0));
		Assert.assertEquals(3, camino.size());
		
		camino =mapa.getHojaDeRuta(new Posicion(20,20,0), new Posicion(14,14,0));
		Assert.assertEquals(7, camino.size());
	}
	
	@Test
	public void test11_CaminoMinimoConObstaculosEnElMapa(){
		Mapa mapa = new Mapa(40, 40);
		
		mapa.agregarElemento(1,9, new ObstaculoTerrestre());
		mapa.agregarElemento(2,9, new ObstaculoTerrestre());
		mapa.agregarElemento(3,9, new ObstaculoTerrestre());
		
		Collection<Posicion>camino = mapa.getHojaDeRuta(new Posicion(1,10,0), new Posicion(3,8,0));
		Assert.assertEquals(5, camino.size());
	}
	
	@Test
	public void test12_MoverUnaUnidadDentroDelMapa(){
		Mapa mapa = new Mapa(40, 40);
		Marine marine = new Marine();
		mapa.agregarElemento(1, 1, marine);
		for (int i=1;i<=3;i++) mapa.pasarTurnoMapa();
		
		Collection<Posicion> camino = marine.mover(3, 6);
		
		Assert.assertEquals(7, camino.size());
		
		for (int i=1;i<=7;i++) mapa.pasarTurnoMapa();
		
		Assert.assertEquals(mapa.getElemento(1, 1, 0), new Tierra());
		Assert.assertEquals(marine, mapa.getElemento(3, 6, 0));
	}
	
	@Test
	public void test13_CantidadDePoblacionInicialEnElMapaEs0(){
		Mapa mapa = new Mapa(40, 40);
		
		Assert.assertEquals(0,0,mapa.getPoblacionTotal());
	}
	
	@Test
	public void test14_AgregarUnElementoNoPoblacionalNoAumentaLaCapacidadDePoblacion(){
		Mapa mapa = new Mapa(40, 40);
		Barraca barraca = new Barraca();
		
		mapa.agregarElemento(3, 3, barraca);
		
		Assert.assertEquals(0,0,mapa.getPoblacionTotal());
	}

	@Test
	public void test15_ElMapaComienzaCon200DeMineralY0DeVespeno(){
		Mapa mapa = new Mapa(40, 40);
		
		Assert.assertEquals(200, mapa.getMineralTotal());
		Assert.assertEquals(0,mapa.getVespenoTotal());
	}
	
	@Test(expected = ErrorRecursosInsuficientes.class)
	public void test16_IntentarAgregarUnEdificioSinSuficientesLanzaError(){
		Mapa mapa = new Mapa(40, 40);

		mapa.agregarElemento(3, 3, new Barraca());
		mapa.agregarElemento(5, 5, new Barraca());
	}
	
	@Test
	public void test17_ObtenerUnaPosicionDisponibleProximaAOtra(){
		Mapa mapa = new Mapa(40, 40);
		mapa.agregarElemento(3, 3, new Mineral());
		Posicion pos = new Posicion(3,3,0);
		
		Assert.assertEquals(new Posicion(3,4,0),mapa.getPosicionProxima(pos));
	}
	
	@Test
	public void test18_ObtenerUnaPosicionDisponibleProximaAOtra2Borde(){
		Mapa mapa = new Mapa(40, 40);	
		mapa.agregarElemento(1,1, new Mineral());
		Assert.assertEquals(new Posicion(1,2,0),mapa.getPosicionProxima(new Posicion(2,2,0)));
	}
	
	@Test
	public void test19_ObtenerUnidadesProximasAUnaPosicion(){
		Mapa mapa = new Mapa(40, 40);
		mapa.agregarElemento(5,5, new Marine());
		mapa.agregarElemento(5,4, new Zealot());
		mapa.agregarElemento(4,4, new Espectro());
		mapa.agregarElemento(4,5, new Barraca());
		mapa.agregarElemento(6,6, new Mineral());
		
		List<Unidad> unidades = mapa.getUnidadesProximas(new Posicion(5,5,0), 2);
		
		Assert.assertEquals(3,unidades.size());
	}
	
}
