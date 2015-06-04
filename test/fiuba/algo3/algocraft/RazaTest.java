package fiuba.algo3.algocraft;

import org.junit.Test;

public class RazaTest {

	@Test
	public void test01_crearRazas(){
		Raza terran = Terran.getInstance();
		Raza protoss = Protoss.getInstance();
		Raza zerg = Zerg.getInstance();
	}
	
	@Test
	public void test02_laRazaTerranDevuelveFabricaDeRazaTerran(){
		Raza terran = Terran.getInstance();
		FabricaDeElementos fabrica = terran.getFabrica();
	}
}
