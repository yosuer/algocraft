package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.excepciones.ErrorNombreDeJugadorInvalido;

public class RecursoTest {

	@Test
	public void test01_crearNodoDeMineralConReservaInicialEn1000()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		Assert.assertEquals(mineral.reservaDisponible(), 1000);
	}
	
	@Test
	public void test02_crearGasVespenoConReservaInicialEn5000()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		Assert.assertEquals(vespeno.reservaDisponible(), 5000);
	}
	
	@Test
	public void test03_CadaExtraccionDeUnMineralDevuelve10DeMineralYReduceEn10LaReservaDisponibleDelMineral()
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
	public void test04_LuegoDeAgotarseLaReservaDeUnMineralEntrega0DeMineral()
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
	public void test05_ElMineralCambiaAEstadoADefinirLuegoDeAgotarseSuReserva()
	{
	}

	@Test
	public void test06_SiAUnMineralSeLeAsignaUnExtractorEnLaMismaPosicionDaOK()
	{
		Posicion pos = new Posicion(1,1);
		Recurso mineral = new Mineral(pos);
		ExtractorDeMineral extractor = new CentroDeMineral(pos);
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertEquals(mineral.getExtractor(), extractor);
	}
	
	@Test
	public void test07_AUnRecursoNoSeLePuedeAsignarUnExtractorDeDistintaPosicion()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		ExtractorDeMineral extractor = new CentroDeMineral(new Posicion(2,2));
		
		mineral.asignarExtractor(extractor);
		
		Assert.assertNull(mineral.getExtractor());
	}
	
	@Test
	public void test08_AUnMineralSoloSeLePuedeAsignar()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		ExtractorDeMineral extractor = new CentroDeMineral(new Posicion(2,2));
		
		mineral.asignarExtractor(extractor);
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test09_AUnMineralSoloSeLePuedeAsignarUnExtractorDeMineral()
	{
		Posicion pos = new Posicion(1,1);
		Recurso mineral = new Mineral(pos);
		ExtractorDeGasVespeno extractor = new Refineria(pos);
		
		mineral.asignarExtractor(extractor);
	}
	
}
