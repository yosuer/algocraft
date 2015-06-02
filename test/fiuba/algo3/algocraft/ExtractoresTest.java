package fiuba.algo3.algocraft;

import org.junit.Test;

public class ExtractoresTest {
	
	@Test
	public void test01_soloSePuedeAgregarExtractorDeMineralSobreMineral()
	{
		Elemento mineral = new Mineral(new Posicion(1,1));
		Extractor extractor =new CentroDeMineral(new Posicion(1,1));
		
	}

}
