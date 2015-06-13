package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class DepositoDeSuministrosTest {

	@Test
	public void test01_CrearUnDepositoDeSuministros(){
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		
		Assert.assertEquals(deposito.vidaActual(), 500);
		Assert.assertEquals(deposito.getCostoMineral(), 100);
		Assert.assertEquals(deposito.getCostoVespeno(), 0);
		Assert.assertEquals(deposito.getNivel(), 0);
	}
	
	@Test
	public void test02_AgregarUnDepositoDeSuministrosAlMapaAumentaPoblacion(){
		Mapa mapa = new Mapa(); //poblacion inicial es 10
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		mapa.agregarElemento(1, 1, deposito);

		Assert.assertEquals(15.0,mapa.getPoblacionTotal(),0.0);
	}
	
	@Test
	public void test03_EliminarUnDepositoDeSuministrosDelMapaDisminuyePoblacion(){
		Mapa mapa = new Mapa(); //poblacion inicial es 10

		mapa.agregarElemento(1, 1, new DepositoDeSuministros());
		mapa.agregarElemento(3, 3, new DepositoDeSuministros());
		Assert.assertEquals(20.0, mapa.getPoblacionTotal(),0.0);
		
		mapa.quitarElemento(mapa.getElemento(1, 1, 0));
		mapa.quitarElemento(mapa.getElemento(3, 3, 0));
		Assert.assertEquals(10.0, mapa.getPoblacionTotal(),0.0);
	}
	
}
