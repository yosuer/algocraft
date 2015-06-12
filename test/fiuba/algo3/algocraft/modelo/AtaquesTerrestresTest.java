package fiuba.algo3.algocraft.modelo;


import org.junit.Assert;
import org.junit.Test;

public class AtaquesTerrestresTest {
	
	@Test
	public void test01_AtaqueEntreUnidadesTerran(){
		Marine marine = new Marine();
		Golliat golliat = new Golliat();
		
		Assert.assertEquals(125,golliat.vidaActual());
		Assert.assertEquals(40,marine.vidaActual());
		
		marine.atacar(golliat);
		golliat.atacar(marine);
		
		Assert.assertEquals(119,golliat.vidaActual());
		Assert.assertEquals(28,marine.vidaActual());
	}
	
	@Test
	public void test02_AtaqueAUnEdificioTerran(){
		Marine marine = new Marine();
		DepositoDeSuministros depo = new DepositoDeSuministros();
		
		Assert.assertEquals(500,depo.vidaActual());
		
		marine.atacar(depo);
		
		Assert.assertEquals(494,depo.vidaActual());
	}
	
	@Test
	public void test03_AtaqueAUnidadProtoss(){
		Golliat golliat = new Golliat();
		Dragon dragon = new Dragon();
		
		Assert.assertEquals(180,dragon.vidaActual());
		Assert.assertEquals(80,dragon.escudoRestante());
		
		golliat.atacar(dragon);
		
		Assert.assertEquals(168,dragon.vidaActual());
		Assert.assertEquals(68,dragon.escudoRestante());
	}
	
	@Test
	public void test04_AtaqueAEdificioProtoss(){
		Espectro espectro = new Espectro();
		Acceso acceso = new Acceso();
		
		Assert.assertEquals(1000,acceso.vidaActual());
		Assert.assertEquals(500,acceso.escudoRestante());
		
		espectro.atacar(acceso);
		
		Assert.assertEquals(992,acceso.vidaActual());
		Assert.assertEquals(492,acceso.escudoRestante());
	}
	
}
