package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.modelo.Posicion;

public class VespenoTest {

	@Test
	public void test01_crearGasVespenoConReservaInicialEn5000()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		Assert.assertEquals(vespeno.reservaDisponible(), 5000);
	}
	
	@Test
	public void test02_CadaExtraccionDeVespenoDevuelve10DeVespenoYReduceEn10LaReservaDisponibleDelVespeno()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
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
		Recurso vespeno = new Vespeno(new Posicion(1,1));
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
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		ExtractorDeGasVespeno extractor = new Refineria(new Posicion(1,1));
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test05_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoTerranDeDistintaPosicion()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		ExtractorDeGasVespeno extractor = new Refineria(new Posicion(2,5));;
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test06_AUnVespenoSoloSeLePuedeAsignarUnExtractorDeVespeno()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		ExtractorDeMineral extractor = new CentroDeMineral(new Posicion(1,1));
		
		vespeno.asignarExtractor(extractor);
	}
	
	@Test
	public void test07_AUnVespenoSoloSeLePuedeAsignarUnExtractorDeVespeno()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		ExtractorDeRecursos extractor = new CentroDeMineral(new Posicion(1,1));
		try {
			vespeno.asignarExtractor(extractor);
		}catch (ErrorExtractorDeRecursosIncompatible e) {
		}
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test
	public void test08_SiAUnVespenoSeLeAsignaUnExtractorDeVespenoProtossEnLaMismaPosicionDaOK()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		ExtractorDeGasVespeno extractor = new Asimilador(new Posicion(1,1));
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test09_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoProtossDeDistintaPosicion()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		ExtractorDeGasVespeno extractor = new Asimilador(new Posicion(2,5));;
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test
	public void test10_SiAUnVespenoSeLeAsignaUnExtractorDeVespenoZergEnLaMismaPosicionDaOK()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		ExtractorDeGasVespeno extractor = new Extractor(new Posicion(1,1));
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test11_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoZergDeDistintaPosicion()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		ExtractorDeGasVespeno extractor = new Extractor(new Posicion(2,5));;
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
}
