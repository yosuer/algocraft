package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class ExtractorTest {

	@Test
	public void test01_soloSePuedeAgregarExtractorDeMineralSobreMineral() {
		Recurso mineral = new Mineral(new Posicion(1, 1));
		ExtractorDeMineral centroDeMineral = new CentroDeMineral(new Posicion(1, 1));

		mineral.asignarExtractor(centroDeMineral);
	}

	@Test
	public void test02_CadaExtraccionDeMineralSuma10EnElDepositoDelExtractor() {
		Recurso mineral = new Mineral(new Posicion(1, 1));
		ExtractorDeMineral centroDeMineral = new CentroDeMineral(new Posicion(
				1, 1));

		Assert.assertEquals(centroDeMineral.getRecoleccion(), 0);// otro test

		mineral.asignarExtractor(centroDeMineral);

		centroDeMineral.realizarExtraccion();

		Assert.assertEquals(centroDeMineral.getRecoleccion(), 10);
	}

	@Test
	public void test03_SiSeExtraeSeisVecesSeTiene60DeMineralRecolectado() {
		Recurso mineral = new Mineral(new Posicion(1, 1));
		ExtractorDeMineral centroDeMineral = new CentroDeMineral(new Posicion(
				1, 1));

		mineral.asignarExtractor(centroDeMineral);

		for (int i = 0; i < 6; i++) {
			centroDeMineral.realizarExtraccion();
		}
		Assert.assertEquals(60, centroDeMineral.getRecoleccion());
	}
	
	@Test
	public void test04_UnCentroDeMineralTieneCostoMinera50YCostoVespeno0(){
		ExtractorDeMineral extractor = new CentroDeMineral(new Posicion(1,1));
		
		Assert.assertEquals(50,extractor.getCostoMineral());
		Assert.assertEquals(0,extractor.getCostoVespeno());
	}

}
