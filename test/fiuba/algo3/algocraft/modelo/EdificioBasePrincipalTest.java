package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class EdificioBasePrincipalTest {
	
	@Test
	public void test01_CrearUnCentroDeMando(){
		Mapa mapa = new Mapa();
		CentroDeMando centroDeMando = new CentroDeMando();
		
		mapa.agregarElemento(1, 1, centroDeMando);
		
		Assert.assertEquals(mapa.getElemento(1, 1, 0), new CentroDeMando());

		for (int i=1; i <=6; i++){
			mapa.pasarTurnoMapa();
		}
		
		Assert.assertEquals(centroDeMando.tiempoDeConstruccion,1);
		
		mapa.pasarTurnoMapa();
		Assert.assertEquals(centroDeMando.tiempoDeConstruccion,0);
		
		Assert.assertEquals(centroDeMando.vidaActual(), 1500);
		Assert.assertEquals(centroDeMando.getCostoMineral(), 100);
		Assert.assertEquals(centroDeMando.getCostoVespeno(), 100);
		Assert.assertEquals(centroDeMando.getNivel(), 0);
	}
	
	@Test
	public void test02_CrearUnNexo(){
		Mapa mapa = new Mapa();
		Nexo nexo = new Nexo();
		
		mapa.agregarElemento(2, 1, nexo);
		Assert.assertEquals(mapa.getElemento(2, 1, 0), new Nexo());
		
		for (int i=1; i <=9; i++){
			mapa.pasarTurnoMapa();
		}
		
		Assert.assertEquals(nexo.tiempoDeConstruccion,0);
		
		Assert.assertEquals(nexo.vidaActual(), 1500);
		//Assert.assertEquals(acceso.escudoActual(), 750);
		Assert.assertEquals(nexo.getCostoMineral(), 100);
		Assert.assertEquals(nexo.getCostoVespeno(), 100);
		Assert.assertEquals(nexo.getNivel(), 0);
	}
	
	@Test
	public void test03_CrearUnCriadero(){
		Mapa mapa = new Mapa();
		Criadero criadero = new Criadero();
		
		mapa.agregarElemento(2, 3, criadero);
		Assert.assertEquals(mapa.getElemento(2, 3, 0), new Criadero());
		
		for (int i=1; i <=10; i++){
			mapa.pasarTurnoMapa();
		}
		
		Assert.assertEquals(criadero.tiempoDeConstruccion,0);
		
		Assert.assertEquals(criadero.vidaActual(), 1500);
		Assert.assertEquals(criadero.getCostoMineral(), 100);
		Assert.assertEquals(criadero.getCostoVespeno(), 100);
		Assert.assertEquals(criadero.getNivel(), 0);
	}
}
