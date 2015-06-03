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
	
	@Test(expected = ErrorExtractorDeRecursosIncompatible.class)
	public void test10_AUnGasVespenoNoSeLePuedeAsignarUnExtractorDeDistintaPosicion()
	{
		Posicion pos = new Posicion(1,1);
		Recurso mineral = new Mineral(pos);
		ExtractorDeGasVespeno extractor = new Refineria(pos);
		
		mineral.asignarExtractor(extractor);
	}
	
}
