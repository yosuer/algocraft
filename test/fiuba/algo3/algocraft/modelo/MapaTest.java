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
import fiuba.algo3.algocraft.modelo.unidades.Marine;

public class MapaTest {
	
	@Test
	public void test01_CrearMapaConTierraDe100X100(){
		Mapa nuevoMapa = new Mapa();
		
		Assert.assertEquals(nuevoMapa.ancho(), 100);
		Assert.assertEquals(nuevoMapa.largo(), 100);	
		Assert.assertEquals(nuevoMapa.alto(), 1);	
	}
	
	@Test
	public void test02_DefinirMineralesEnUnaPosicionDelMapa(){
		Mapa mapa = new Mapa();
		IElemento mineral = new Mineral();
		
		mapa.agregarElemento(1,1,mineral);
		
		Assert.assertEquals(mineral,mapa.getElemento(1,1,0));	
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
		
		mapa.agregarElemento(4,4,obstaculoTerrestre);
		
		Assert.assertEquals(mapa.getElemento(4,4,0),obstaculoTerrestre);
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
	
	@Test
	public void test08_CrearUnMapaConRecursosPredeterminados(){
		Mapa mapa = new Mapa();
		
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
		
		Collection<Posicion>camino = new ArrayList<Posicion>();
		camino = mapa.getHojaDeRuta(new Posicion(3,3,0),new Posicion(6,6,0));
		
		Assert.assertEquals(4, camino.size());
		
		ArrayList<Posicion> caminoEsperado = new ArrayList<Posicion>();
		caminoEsperado.add(new Posicion(3,3,0));
		caminoEsperado.add(new Posicion(4,4,0));
		caminoEsperado.add(new Posicion(5,5,0));
		caminoEsperado.add(new Posicion(6,6,0));
		
		Assert.assertEquals(caminoEsperado, camino);
	}

	@Test
	public void test09_AlIniciarElMapaSePuedeRecorrerTodasLasPosiciones2(){
		Mapa mapa = new Mapa();
		
		Collection<Posicion>camino =mapa.getHojaDeRuta(new Posicion(95,95,0), new Posicion(80,80,0));
		
		Assert.assertEquals(16, camino.size());
	}
	
	@Test
	public void test09_CaminoMinimoConObstaculosEnElMapa(){
		Mapa mapa = new Mapa();
		
		mapa.agregarElemento(1,9, new ObstaculoTerrestre());
		mapa.agregarElemento(2,9, new ObstaculoTerrestre());
		mapa.agregarElemento(3,9, new ObstaculoTerrestre());
		
		Collection<Posicion>camino = mapa.getHojaDeRuta(new Posicion(1,10,0), new Posicion(3,8,0));
		Assert.assertEquals(5, camino.size());
	}
	
	@Test
	public void test10_MoverUnaUnidadDentroDelMapa(){
		Mapa mapa = new Mapa();
		Marine marine = new Marine();
		mapa.agregarElemento(1, 1, marine);
		for (int i=1;i<=3;i++) mapa.pasarTurnoMapa();
		
		Collection<Posicion> camino = marine.mover(3, 6);
		
		Assert.assertEquals(7, camino.size());
		
		for (int i=1;i<=7;i++) mapa.pasarTurnoMapa();
		
		Assert.assertNull(mapa.getElemento(1, 1, 0));
		Assert.assertEquals(marine, mapa.getElemento(3, 6, 0));
	}
	
	@Test
	public void test11_CantidadDePoblacionInicialEnElMapaEs0(){
		Mapa mapa = new Mapa();
		
		Assert.assertEquals(0,0,mapa.getPoblacionTotal());
	}
	
	@Test
	public void test12_AgregarUnElementoNoPoblacionalNoAumentaLaCapacidadDePoblacion(){
		Mapa mapa = new Mapa();
		Barraca barraca = new Barraca();
		
		mapa.agregarElemento(3, 3, barraca);
		
		Assert.assertEquals(0,0,mapa.getPoblacionTotal());
	}

	@Test
	public void test15_ElMapaComienzaCon200DeMineralY0DeVespeno(){
		Mapa mapa = new Mapa();
		
		Assert.assertEquals(200, mapa.getMineralTotal());
		Assert.assertEquals(0,mapa.getVespenoTotal());
	}
	
	@Test(expected = ErrorRecursosInsuficientes.class)
	public void test16_IntentarAgregarUnEdificioSinSuficientesLanzaError(){
		Mapa mapa = new Mapa();

		mapa.agregarElemento(3, 3, new Barraca());
		mapa.agregarElemento(5, 5, new Barraca());
	}
	
	@Test
	public void test17_ObtenerUnaPosicionDisponibleProximaAOtra(){
		Mapa mapa = new Mapa();
		mapa.agregarElemento(3, 3, new Mineral());
		Posicion pos = new Posicion(3,3,0);
		
		Assert.assertEquals(new Posicion(3,4,0),mapa.getPosicionProxima(pos));
	}
	
	@Test
	public void test18_ObtenerUnaPosicionDisponibleProximaAOtra2Borde(){
		Mapa mapa = new Mapa();	
		mapa.agregarElemento(1,1, new Mineral());
		Assert.assertEquals(new Posicion(1,2,0),mapa.getPosicionProxima(new Posicion(2,2,0)));
	}
	
}
