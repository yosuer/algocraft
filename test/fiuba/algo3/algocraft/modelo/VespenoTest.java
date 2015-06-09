package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.modelo.Posicion;

public class VespenoTest {

	@Test
	public void test01_crearGasVespenoConReservaInicialEn1000()
	{
		Recurso vespeno = new Vespeno();
		Assert.assertEquals(vespeno.reservaDisponible(), 1000);
	}
	
	@Test
	public void test02_CadaExtraccionDeVespenoDevuelve10DeVespenoYReduceEn10LaReservaDisponibleDelVespeno()
	{
		
		Recurso vespeno = new Vespeno();
		int cantidad = vespeno.extraer();
		
		Assert.assertEquals(990, vespeno.reservaDisponible());
		Assert.assertEquals(cantidad,10);
		
		cantidad = vespeno.extraer();
		Assert.assertEquals(980, vespeno.reservaDisponible());
		Assert.assertEquals(cantidad,10);
	}
	
	@Test
	public void test03_LuegoDeAgotarseLaReservaDeVespenoEntrega0DeVespeno()
	{
		Recurso vespeno = new Vespeno();
		int cantidad = 0;
		
		for (int i = 0; i < 101; i++){
			cantidad = vespeno.extraer();
		}
		Assert.assertEquals(vespeno.reservaDisponible(), 0);
		Assert.assertEquals(cantidad, 0);
	}
	
	@Test
	public void test04_SiAUnVespenoSeLeAsignaUnExtractorDeVespenoTerranEnLaMismaPosicionDaOK()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Refineria();
		
		mapa.agregarElemento(2, 5, vespeno);
		mapa.agregarElemento(2, 5, extractor);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test05_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoTerranDeDistintaPosicion()
	{
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Refineria();
		
		Posicion posVespeno = new Posicion(2,2,0);
		vespeno.setPosicion(posVespeno);
		Posicion posExtractor = new Posicion(3,2,0);
		extractor.setPosicion(posExtractor);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test06_AUnVespenoSoloSeLePuedeAsignarUnExtractorDeVespeno()
	{
		
		Recurso vespeno = new Vespeno();
		ExtractorDeMineral extractor = new CentroDeMineral();
		
		Posicion pos = new Posicion(1,2,0);
		vespeno.setPosicion(pos);
		extractor.setPosicion(pos);
		
		vespeno.asignarExtractor(extractor);
	}
	
	@Test
	public void test07_AUnVespenoSoloSeLePuedeAsignarUnExtractorDeVespeno()
	{
		
		Recurso vespeno = new Vespeno();
		ExtractorDeMineral extractor = new CentroDeMineral();
		
		Posicion pos = new Posicion(5,2,0);
		vespeno.setPosicion(pos);
		extractor.setPosicion(pos);
		
		try {
			vespeno.asignarExtractor(extractor);
		}catch (ErrorExtractorDeRecursosIncompatible e) {
		}
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test
	public void test08_SiAUnVespenoSeLeAsignaUnExtractorDeVespenoProtossEnLaMismaPosicionDaOK()
	{
		
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Asimilador();
		
		Posicion pos = new Posicion(3,7,0);
		vespeno.setPosicion(pos);
		extractor.setPosicion(pos);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test09_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoProtossDeDistintaPosicion()
	{
		Mapa mapa = new Mapa();
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Asimilador();
		
		mapa.agregarElemento(4, 1, vespeno);
		mapa.agregarElemento(1,4,extractor);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
	
	@Test
	public void test10_SiAUnVespenoSeLeAsignaUnExtractorDeVespenoZergEnLaMismaPosicionDaOK()
	{
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Extractor();
		
		Posicion pos = new Posicion(3,3,0);
		vespeno.setPosicion(pos);
		extractor.setPosicion(pos);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertEquals(vespeno.getExtractor(), extractor);
	}
	
	@Test
	public void test11_AUnVespenoNoSeLePuedeAsignarUnExtractorDeVespenoZergDeDistintaPosicion()
	{
		
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Extractor();
		
		Posicion posVespeno = new Posicion(2,3,0);
		vespeno.setPosicion(posVespeno);
		Posicion posExtractor = new Posicion(4,1,0);
		extractor.setPosicion(posExtractor);
		
		vespeno.asignarExtractor(extractor);
		
		Assert.assertNull(vespeno.getExtractor());
	}
}
