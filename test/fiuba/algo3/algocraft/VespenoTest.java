package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;

public class VespenoTest {

	@Test
	public void test01_crearGasVespenoConReservaInicialEn5000()
	{
		Recurso vespeno = new Vespeno(new Posicion(1,1));
		Assert.assertEquals(vespeno.reservaDisponible(), 5000);
	}
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test10_AUnGasVespenoNoSeLePuedeAsignarUnExtractorDeDistintaPosicion()
	{
		Posicion pos = new Posicion(1,1);
		Recurso mineral = new Mineral(pos);
		ExtractorDeGasVespeno extractor = new Refineria(pos);
		
		mineral.asignarExtractor(extractor);
	}
	
}
