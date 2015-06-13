package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ExtractorVespenoTest {

	@Test
	public void test01_soloSePuedeAgregarExtractorDeVespenoSobreUnRecursoVespeno() {
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Refineria();
		
		Posicion pos = new Posicion(4,3,0);
		vespeno.setPosicion(pos);
		extractor.setPosicion(pos);

		extractor.asignarRecurso(vespeno);
	}
	
	@Test
	public void test02_CadaExtraccionDeVespenoSuma10EnElDepositoDelExtractor() {
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Refineria();
		Posicion pos = new Posicion(3,2,0);
		
		Assert.assertEquals(extractor.getRecolectado(), 0);
		
		vespeno.setPosicion(pos);
		extractor.setPosicion(pos);
		extractor.asignarRecurso(vespeno);

		extractor.realizarExtraccion();

		Assert.assertEquals(extractor.getRecolectado(), 10);
	}
	
	@Test
	public void test03_SiSeExtraeSeisVecesSeTiene60DeVespenoRecolectado() {
		Recurso vespeno = new Vespeno();
		ExtractorDeGasVespeno extractor = new Refineria();
		Posicion pos = new Posicion(9,2,0);
		vespeno.setPosicion(pos);
		extractor.setPosicion(pos);

		extractor.asignarRecurso(vespeno);

		for (int i = 0; i < 6; i++) {
			extractor.realizarExtraccion();
		}
		Assert.assertEquals(60, extractor.getRecolectado());
	}
	
	@Test
	public void test04_VerificarCostosDeLosExtractoresDeVespeno(){
		ExtractorDeGasVespeno refineria = new Refineria();
		ExtractorDeGasVespeno extractor = new Extractor();
		ExtractorDeGasVespeno asimilador = new Asimilador();
		
		
		Assert.assertEquals(100,extractor.getCostoMineral());
		Assert.assertEquals(0,extractor.getCostoVespeno());
		Assert.assertEquals(100,refineria.getCostoMineral());
		Assert.assertEquals(0,refineria.getCostoVespeno());
		Assert.assertEquals(100,asimilador.getCostoMineral());
		Assert.assertEquals(0,asimilador.getCostoVespeno());
	}
	
	@Test
	public void test05_RefineriaExtraeVespenoPorTurnosDelMapa(){
		Mapa mapa = new Mapa();
		ExtractorDeGasVespeno refineria = new Refineria();
		Vespeno vespeno = new Vespeno();
		
		mapa.agregarElemento(1, 1, vespeno);
		mapa.agregarElemento(1, 1, refineria);
	
		for (int i = 1; i <=4; i++) 
			mapa.pasarTurnoMapa();
		
		for (int i = 1; i <=2; i++) 
			refineria.realizarExtraccion();
		
		Assert.assertEquals(20,refineria.getRecolectado());
		Assert.assertEquals(0, mapa.getVespenoTotal());
		
		mapa.pasarTurnoMapa();
		
		Assert.assertEquals(20, mapa.getVespenoTotal());
		Assert.assertEquals(10, refineria.getRecolectado());
	}

}
