package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.unidades.Golliat;

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
		
		mapa.getElemento(1, 1, 0).eliminarseDelMapa(mapa);
		mapa.getElemento(3, 3, 0).eliminarseDelMapa(mapa);
		Assert.assertEquals(10.0, mapa.getPoblacionTotal(),0.0);
	}
	
	@Test
	public void test04_DestruirDepositoDeSuministrosDisminuyePoblacion(){
		Mapa mapa = new Mapa(); //poblacion inicial es 10

		mapa.agregarElemento(1, 1, new DepositoDeSuministros());
		mapa.agregarElemento(2, 2, new Golliat());
		
		IAtacante golliat = (IAtacante) mapa.getElemento(2,2,0);
		
		golliat.atacar((IDaniable)mapa.getElemento(1, 1, 0));
		
		Assert.assertEquals(((Controlable)mapa.getElemento(1, 1, 0)).vidaActual(), 488);
		Assert.assertEquals(13.0, mapa.getPoblacionTotal(),0.0);
		
		for (int i=1; i<=40; i++)
			golliat.atacar((IDaniable)mapa.getElemento(1, 1, 0));
		
		Assert.assertEquals(((Controlable)mapa.getElemento(1, 1, 0)).vidaActual(), 8);
		Assert.assertEquals(13.0, mapa.getPoblacionTotal(),0.0);
		
		golliat.atacar((IDaniable)mapa.getElemento(1, 1, 0));
		
		Assert.assertNull(mapa.getElemento(1, 1, 0));
		Assert.assertEquals(8.0, mapa.getPoblacionTotal(),0.0);
	}
	
	
	
}
