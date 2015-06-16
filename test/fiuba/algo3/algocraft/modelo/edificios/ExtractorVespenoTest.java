package fiuba.algo3.algocraft.modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Recurso;
import fiuba.algo3.algocraft.modelo.Vespeno;
import fiuba.algo3.algocraft.modelo.edificios.Asimilador;
import fiuba.algo3.algocraft.modelo.edificios.Extractor;
import fiuba.algo3.algocraft.modelo.edificios.Refineria;

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
		
		mapa.agregarElemento(4, 6, refineria);
	
		for (int i = 1; i <=4; i++) 
			mapa.pasarTurnoMapa();
		Assert.assertEquals(0, mapa.getVespenoTotal());
		mapa.pasarTurnoMapa();
		
		Assert.assertEquals(10, mapa.getVespenoTotal());
		
		mapa.pasarTurnoMapa();
		mapa.pasarTurnoMapa();
		Assert.assertEquals(30, mapa.getVespenoTotal());
	}

}
