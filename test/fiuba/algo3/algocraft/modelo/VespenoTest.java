package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.modelo.Posicion;

public class VespenoTest {

	@Test
	public void test01_crearGasVespenoConReservaInicialEn5000()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		Assert.assertEquals(vespeno.reservaDisponible(), 5000);
	}
	
	@Test
	public void test02_CadaExtraccionDeVespenoDevuelve10DeVespenoYReduceEn10LaReservaDisponibleDelVespeno()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		int cantidad = vespeno.extraer();
		
		Assert.assertEquals(4990, vespeno.reservaDisponible());
		Assert.assertEquals(cantidad,10);
		
		cantidad = vespeno.extraer();
		Assert.assertEquals(4980, vespeno.reservaDisponible());
		Assert.assertEquals(cantidad,10);
	}
	
	@Test
	public void test03_LuegoDeAgotarseLaReservaDeVespenoEntrega0DeVespeno()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		int cantidad = 0;
		
		for (int i = 0; i < 501; i++){
			cantidad = vespeno.extraer();
		}
		Assert.assertEquals(vespeno.reservaDisponible(), 0);
		Assert.assertEquals(cantidad, 0);
	}
	
	@Test
	public void test04_SiAUnVespenoSeLeAsignaUnExtractorDeVespenoTerranEnLaMismaPosicionDaOK()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		ExtractorDeGasVespeno extractor = new Refineria(mapa);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test05_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoTerranDeDistintaPosicion()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		ExtractorDeGasVespeno extractor = new Refineria(mapa);;
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test06_AUnVespenoSoloSeLePuedeAsignarUnExtractorDeVespeno()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		ExtractorDeMineral extractor = new CentroDeMineral(mapa);
		
		vespeno.asignarExtractor(extractor);
	}
	
	@Test
	public void test07_AUnVespenoSoloSeLePuedeAsignarUnExtractorDeVespeno()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		ExtractorDeRecursos extractor = new CentroDeMineral(mapa);
		try {
			vespeno.asignarExtractor(extractor);
		}catch (ErrorExtractorDeRecursosIncompatible e) {
		}
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test
	public void test08_SiAUnVespenoSeLeAsignaUnExtractorDeVespenoProtossEnLaMismaPosicionDaOK()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		ExtractorDeGasVespeno extractor = new Asimilador(mapa);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test09_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoProtossDeDistintaPosicion()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		ExtractorDeGasVespeno extractor = new Asimilador(mapa);;
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test
	public void test10_SiAUnVespenoSeLeAsignaUnExtractorDeVespenoZergEnLaMismaPosicionDaOK()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		ExtractorDeGasVespeno extractor = new Extractor(mapa);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test11_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoZergDeDistintaPosicion()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno(mapa);
		ExtractorDeGasVespeno extractor = new Extractor(mapa);;
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
}
