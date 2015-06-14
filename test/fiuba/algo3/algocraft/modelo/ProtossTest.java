package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ProtossTest {

	@Test
	public void test01_LasUnidadesProtossRegenerarSuEscudoCadaTurno(){
		Dragon dragon = new Dragon();
		Marine marine = new Marine();
		for (int i=1; i<=6; i++) dragon.pasarTurno(); //se construyen
		
		marine.atacar(dragon);
		
		Assert.assertEquals(74,dragon.escudoRestante());
		
		dragon.pasarTurno();
		
		Assert.assertEquals(79,dragon.escudoRestante());
	}
}
