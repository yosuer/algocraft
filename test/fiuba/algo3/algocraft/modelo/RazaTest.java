package fiuba.algo3.algocraft.modelo;

import org.junit.Test;

import fiuba.algo3.algocraft.FabricaDeElementos;
import fiuba.algo3.algocraft.Protoss;
import fiuba.algo3.algocraft.Raza;
import fiuba.algo3.algocraft.Terran;
import fiuba.algo3.algocraft.Zerg;

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
