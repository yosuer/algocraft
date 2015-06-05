package fiuba.algo3.algocraft.modelo;

import org.junit.Test;

import fiuba.algo3.algocraft.FabricaDeElementos;
import fiuba.algo3.algocraft.FabricaTerran;
import fiuba.algo3.algocraft.Protoss;
import fiuba.algo3.algocraft.Raza;
import fiuba.algo3.algocraft.Terran;
import fiuba.algo3.algocraft.Zerg;

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
