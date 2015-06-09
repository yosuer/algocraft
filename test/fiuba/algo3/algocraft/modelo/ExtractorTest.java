package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class ExtractorTest {

	@Test
	public void test01_soloSePuedeAgregarExtractorDeMineralSobreMineral() {
		Recurso mineral = new Mineral();
		ExtractorDeMineral centroDeMineral = new CentroDeMineral();
		
		Posicion pos = new Posicion(4,3,0);
		mineral.setPosicion(pos);
		centroDeMineral.setPosicion(pos);

		mineral.asignarExtractor(centroDeMineral);
	}

	@Test
	public void test02_CadaExtraccionDeMineralSuma10EnElDepositoDelExtractor() {
		
		Recurso mineral = new Mineral();
		ExtractorDeMineral centroDeMineral = new CentroDeMineral();

		Assert.assertEquals(centroDeMineral.getRecoleccion(), 0);// otro test
		
		Posicion pos = new Posicion(3,2,0);
		mineral.setPosicion(pos);
		centroDeMineral.setPosicion(pos);

		mineral.asignarExtractor(centroDeMineral);

		//centroDeMineral.realizarExtraccion();

		//Assert.assertEquals(centroDeMineral.getRecoleccion(), 10);
	}

//	@Test
//	public void test03_SiSeExtraeSeisVecesSeTiene60DeMineralRecolectado() {
//		Recurso mineral = new Mineral();
//		ExtractorDeMineral centroDeMineral = new CentroDeMineral();
//		
//		Posicion pos = new Posicion(9,2,0);
//		mineral.setPosicion(pos);
//		centroDeMineral.setPosicion(pos);
//
//		mineral.asignarExtractor(centroDeMineral);
//
//		for (int i = 0; i < 6; i++) {
//			centroDeMineral.realizarExtraccion();
//		}
//		Assert.assertEquals(60, centroDeMineral.getRecoleccion());
//	}
	
	@Test
	public void test04_UnCentroDeMineralTieneCostoMinera50YCostoVespeno0(){
		ExtractorDeMineral extractor = new CentroDeMineral();
		
		Assert.assertEquals(50,extractor.getCostoMineral());
		Assert.assertEquals(0,extractor.getCostoVespeno());
	}
	
	@Test
	public void test04_CentroDeMineralConTurnos(){
		Mapa mapa = new Mapa();
		CentroDeMineral centro = new CentroDeMineral();
		Mineral mineral = new Mineral();
		
		mapa.agregarElemento(1, 1, mineral);
		mapa.agregarElemento(1, 1, centro);
	
		for (int i = 1; i <= 4; i++) {
			mapa.pasarTurno();
		}
		
		Assert.assertEquals(centro.getRecoleccion(),0);
		
		for (int i = 1; i <= 22; i++) {
			mapa.pasarTurno();
		}
		
		Assert.assertEquals(centro.getRecoleccion(),200);
	}
}
