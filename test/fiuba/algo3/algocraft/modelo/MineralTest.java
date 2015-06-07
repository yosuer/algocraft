package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.modelo.Posicion;

public class MineralTest {

	@Test
	public void test01_crearNodoDeMineralConReservaInicialEn200()
	{
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		Assert.assertEquals(mineral.reservaDisponible(), 200);
	}
	
	@Test
	public void test02_CadaExtraccionDeUnMineralDevuelve10DeMineralYReduceEn10LaReservaDisponibleDelMineral()
	{
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
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
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
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
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeMineral extractor = new CentroDeMineral(mapa);
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertEquals(mineral.getExtractor(), extractor);
	}
	
	@Test
	public void test05_AUnMineralNoSeLePuedeAsignarUnExtractorMineralTerranDeDistintaPosicion()
	{
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeMineral extractor = new CentroDeMineral(mapa);
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertNull(mineral.getExtractor());
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test06_AUnMineralSoloSeLePuedeAsignarUnExtractorDeMineral()
	{
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeGasVespeno extractor = new Refineria(mapa);
		
		mineral.asignarExtractor(extractor);
	}
	
	@Test
	public void test07_AUnMineralSoloSeLePuedeAsignarUnExtractorDeMineral()
	{
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeRecursos extractor = new Refineria(mapa);
		try {
			mineral.asignarExtractor(extractor);
		}catch (ErrorExtractorDeRecursosIncompatible e) {
		}
		
		Assert.assertNull(mineral.getExtractor());
	}
	
	@Test
	public void test08_SiAUnMineralSeLeAsignaUnExtractorMineralProtossEnLaMismaPosicionDaOK()
	{
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeMineral extractor = new NexoMineral(mapa);
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertEquals(mineral.getExtractor(), extractor);
	}
	
	@Test
	public void test09_AUnMineralNoSeLePuedeAsignarUnExtractorMineralProtossnDeDistintaPosicion()
	{
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeMineral extractor = new NexoMineral(mapa);
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertNull(mineral.getExtractor());
	}
	
	@Test
	public void testXX_ElRecursoCambiaAEstadoADefinirLuegoDeAgotarseSuReserva()
	{
	}
	
}
