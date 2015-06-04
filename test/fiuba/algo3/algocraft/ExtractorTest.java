package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

public class ExtractorTest {
	
	@Test
	public void test01_soloSePuedeAgregarExtractorDeMineralSobreMineral()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		ExtractorDeMineral centroDeMineral = new CentroDeMineral(new Posicion(1,1));
		
		mineral.asignarExtractor(centroDeMineral);
	}
	
	@Test
	public void test02_CadaExtraccionDeMineralSuma10EnElDepositoDelExtractor()
	{
		Recurso mineral = new Mineral(new Posicion(1,1));
		ExtractorDeMineral centroDeMineral = new CentroDeMineral(new Posicion(1,1));
		
		mineral.asignarExtractor(centroDeMineral);
		
		centroDeMineral.realizarExtraccion();
		
		Assert.assertEquals(centroDeMineral.getRecoleccion(),10);
	}
	
	

}
