package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class ExtractorTest {

	@Test
	public void test01_soloSePuedeAgregarExtractorDeMineralSobreMineral() {
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeMineral centroDeMineral = new CentroDeMineral(mapa);

		mineral.asignarExtractor(centroDeMineral);
	}

	@Test
	public void test02_CadaExtraccionDeMineralSuma10EnElDepositoDelExtractor() {
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeMineral centroDeMineral = new CentroDeMineral(mapa);

		Assert.assertEquals(centroDeMineral.getRecoleccion(), 0);// otro test

		mineral.asignarExtractor(centroDeMineral);

		centroDeMineral.realizarExtraccion();

		Assert.assertEquals(centroDeMineral.getRecoleccion(), 10);
	}

	@Test
	public void test03_SiSeExtraeSeisVecesSeTiene60DeMineralRecolectado() {
		Mapa mapa = new Mapa();
		Recurso mineral = new Mineral(mapa);
		ExtractorDeMineral centroDeMineral = new CentroDeMineral(mapa);

		mineral.asignarExtractor(centroDeMineral);

		for (int i = 0; i < 6; i++) {
			centroDeMineral.realizarExtraccion();
		}
		Assert.assertEquals(60, centroDeMineral.getRecoleccion());
	}
	
	@Test
	public void test04_UnCentroDeMineralTieneCostoMinera50YCostoVespeno0(){
		Mapa mapa = new Mapa();
		ExtractorDeMineral extractor = new CentroDeMineral(mapa);
		
		Assert.assertEquals(50,extractor.getCostoMineral());
		Assert.assertEquals(0,extractor.getCostoVespeno());
	}

}
