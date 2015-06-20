package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.excepciones.ErrorNoExisteRecursoEnLaPosicion;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.NexoMineral;
import fiuba.algo3.algocraft.modelo.edificios.Refineria;
import fiuba.algo3.algocraft.modelo.natural.Mineral;

public class MineralTest {

	@Test
	public void test01_crearNodoDeMineralConReservaInicialEn200()
	{
		Recurso mineral = new Mineral();
		Assert.assertEquals(mineral.reservaDisponible(), 200);
	}
	
	@Test
	public void test02_CadaExtraccionDeUnMineralDevuelve10DeMineralYReduceEn10LaReservaDisponibleDelMineral()
	{
		Recurso mineral = new Mineral();
		int cantidad = mineral.extraer();
		
		Assert.assertEquals(190, mineral.reservaDisponible());
		Assert.assertEquals(cantidad,10);
		
		cantidad = mineral.extraer();
		Assert.assertEquals(180, mineral.reservaDisponible());
		Assert.assertEquals(cantidad,10);
	}
	
	@Test
	public void test03_LuegoDeAgotarseLaReservaDeUnMineralEntrega0DeMineral()
	{
		Recurso mineral = new Mineral();
		int cantidad = 0;
		
		for (int i = 0; i < 101; i++){
			cantidad = mineral.extraer();
		}
		Assert.assertEquals(mineral.reservaDisponible(), 0);
		Assert.assertEquals(cantidad, 0);
	}

	@Test
	public void test04_SiAUnMineralSeLeAsignaUnExtractorMineralTerranEnLaMismaPosicionDaOK()
	{
		Mapa mapa = new Mapa(40, 40);
		ExtractorDeMineral extractor = new CentroDeMineral();
		
		mapa.agregarElemento(3, 2, extractor);
		
		Assert.assertEquals(mapa.getElemento(3, 2, 0), extractor);
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	//@Test(expected = ErrorNoExisteRecursoEnLaPosicion.class)
	public void test05_AUnMineralNoSeLePuedeAsignarUnExtractorMineralTerranDeDistintaPosicion()
	{
		Mapa mapa = new Mapa(40, 40);
		Recurso mineral = new Mineral();
		ExtractorDeMineral extractor = new CentroDeMineral();
		
		mapa.agregarElemento(5, 5, mineral);
		mapa.agregarElemento(4, 4, extractor);
		
		mineral.asignarExtractor(extractor);
		
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test06_AUnMineralSoloSeLePuedeAsignarUnExtractorDeMineral()
	{
		
		Recurso mineral = new Mineral();
		ExtractorDeGasVespeno extractor = new Refineria();
		
		Posicion pos = new Posicion(2,3,0);
		mineral.setPosicion(pos);
		extractor.setPosicion(pos);
		
		mineral.asignarExtractor(extractor);
	}
	
	@Test
	public void test07_AUnMineralSoloSeLePuedeAsignarUnExtractorDeMineral()
	{
		Recurso mineral = new Mineral();
		ExtractorDeGasVespeno extractor = new Refineria();
		
		Posicion pos = new Posicion(3,2,0);
		mineral.setPosicion(pos);
		extractor.setPosicion(pos);
		
		try {
			mineral.asignarExtractor(extractor);
		}catch (ErrorExtractorDeRecursosIncompatible e) {
		}
		
		Assert.assertNull(mineral.getExtractor());
	}
	
	@Test
	public void test08_SiAUnMineralSeLeAsignaUnExtractorMineralProtossEnLaMismaPosicionDaOK()
	{
		Recurso mineral = new Mineral();
		ExtractorDeMineral extractor = new NexoMineral();
		
		Posicion pos = new Posicion(1,1,0);
		mineral.setPosicion(pos);
		extractor.setPosicion(pos);
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertEquals(mineral.getExtractor(), extractor);
	}
	
	@Test
	public void test09_AUnMineralNoSeLePuedeAsignarUnExtractorMineralProtossnDeDistintaPosicion()
	{
		
		Recurso mineral = new Mineral();
		ExtractorDeMineral extractor = new NexoMineral();
		
		Posicion posMineral = new Posicion(1,3,0);
		mineral.setPosicion(posMineral);
		
		Posicion posExtractor = new Posicion(6,1,0);
		extractor.setPosicion(posExtractor);
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertNull(mineral.getExtractor());
	}
	
	@Test
	public void testXX_ElRecursoCambiaAEstadoADefinirLuegoDeAgotarseSuReserva()
	{
	}
	
}
