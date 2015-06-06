package fiuba.algo3.algocraft.modelo;

import org.junit.Test;

public class RazaTest {

	@Test
	public void test01_crearRazas(){
		Raza terran = new Terran();
		Raza protoss = new Protoss();
		Raza zerg = new Zerg();
	}
	
	@Test
	public void test02_laRazaTerranDevuelveFabricaDeRazaTerran(){
		Raza terran = new Terran();
		FabricaTerran fabrica = (FabricaTerran) terran.getFabrica();
	}
}
