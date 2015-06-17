package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.unidades.Dragon;
import fiuba.algo3.algocraft.modelo.unidades.Marine;

public class ProtossTest {

	@Test
	public void test01_LasUnidadesProtossRegenerarSuEscudoCadaTurno(){
		Mapa mapa = new Mapa();
		Dragon dragon = new Dragon();
		Marine marine = new Marine();
		mapa.agregarElemento(1, 1, dragon);
		mapa.agregarElemento(1, 2, marine);
		for (int i=1; i<=6; i++) dragon.pasarTurno(); //se construyen
		
		marine.atacar(dragon);
		
		Assert.assertEquals(74,dragon.escudoRestante());
		
		dragon.pasarTurno();
		
		Assert.assertEquals(79,dragon.escudoRestante());
	}
}
