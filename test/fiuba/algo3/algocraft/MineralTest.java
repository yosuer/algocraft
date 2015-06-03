package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;

public class MineralTest {

	@Test
	public void test01_crearNodoDeMineralConReservaInicialEn1000()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		Assert.assertEquals(mineral.reservaDisponible(), 1000);
	}
	
	@Test
	public void test02_CadaExtraccionDeUnMineralDevuelve10DeMineralYReduceEn10LaReservaDisponibleDelMineral()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		int cantidad = mineral.extraer();
		
		Assert.assertEquals(990, mineral.reservaDisponible());
		Assert.assertEquals(cantidad,10);
		
		cantidad = mineral.extraer();
		Assert.assertEquals(980, mineral.reservaDisponible());
		Assert.assertEquals(cantidad,10);
	}
	
	@Test
	public void test03_LuegoDeAgotarseLaReservaDeUnMineralEntrega0DeMineral()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		int cantidad = 0;
		
		for (int i = 0; i < 101; i++){
			cantidad = mineral.extraer();
		}
		Assert.assertEquals(mineral.reservaDisponible(), 0);
		Assert.assertEquals(cantidad, 0);
	}

	@Test
	public void test04_SiAUnMineralSeLeAsignaUnExtractorMineralEnLaMismaPosicionDaOK()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		ExtractorDeMineral extractor = new CentroDeMineral(new Posicion(1,1));
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertEquals(mineral.getExtractor(), extractor);
	}
	
	@Test
	public void test05_AUnMineralNoSeLePuedeAsignarUnExtractorMineralDeDistintaPosicion()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		ExtractorDeMineral extractor = new CentroDeMineral(new Posicion(2,2));
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertNull(mineral.getExtractor());
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test06_AUnMineralSoloSeLePuedeAsignarUnExtractorDeMineral()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		ExtractorDeGasVespeno extractor = new Refineria(new Posicion(1,1));
		
		mineral.asignarExtractor(extractor);
	}
	
	@Test
	public void test07_AUnMineralSoloSeLePuedeAsignarUnExtractorDeMineral()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		ExtractorDeRecursos extractor = new Refineria(new Posicion(1,1));
		try {
			mineral.asignarExtractor(extractor);
		}catch (ErrorExtractorDeRecursosIncompatible e) {
		}
		
		Assert.assertNull(mineral.getExtractor());
	}
	
	
	@Test
	public void testXX_ElRecursoCambiaAEstadoADefinirLuegoDeAgotarseSuReserva()
	{
	}
	
}
