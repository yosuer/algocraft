package fiuba.algo3.algocraft.modelo.edificios;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Controlable;
import fiuba.algo3.algocraft.modelo.IAtacante;
import fiuba.algo3.algocraft.modelo.IDaniable;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.natural.Tierra;
import fiuba.algo3.algocraft.modelo.unidades.Golliat;

public class DepositoDeSuministrosTest {

	@Test
	public void test01_CrearUnDepositoDeSuministros() {
		DepositoDeSuministros deposito = new DepositoDeSuministros();

		Assert.assertEquals(deposito.vidaActual(), 500);
		Assert.assertEquals(deposito.getCostoMineral(), 100);
		Assert.assertEquals(deposito.getCostoVespeno(), 0);
		Assert.assertEquals(deposito.getNivel(), 0);
	}

	@Test
	public void test02_AgregarUnDepositoDeSuministrosAlMapaAumentaPoblacion() {
		Mapa mapa = new Mapa(40, 40); // poblacion inicial es 10
		DepositoDeSuministros deposito = new DepositoDeSuministros();
		mapa.agregarElemento(1, 1, deposito);

		Assert.assertEquals(5.0, mapa.getPoblacionTotal(), 0.0);
	}

	@Test
	public void test03_EliminarUnDepositoDeSuministrosDelMapaDisminuyePoblacion() {
		Mapa mapa = new Mapa(40, 40); // poblacion inicial es 10

		mapa.agregarElemento(1, 1, new DepositoDeSuministros());
		mapa.agregarElemento(3, 3, new DepositoDeSuministros());
		Assert.assertEquals(10.0, mapa.getPoblacionTotal(), 0.0);

		mapa.getElemento(1, 1, 0).eliminarseDelMapa(mapa);
		mapa.getElemento(3, 3, 0).eliminarseDelMapa(mapa);
		Assert.assertEquals(0.0, mapa.getPoblacionTotal(), 0.0);
	}

	@Test
	public void test04_DestruirDepositoDeSuministrosDisminuyePoblacion() {
		Mapa mapa = new Mapa(40, 40); // poblacion inicial es 10

		mapa.agregarElemento(3, 3, new DepositoDeSuministros());
		mapa.agregarElemento(5, 5, new Golliat());

		IAtacante golliat = (IAtacante) mapa.getElemento(5, 5, 0);

		golliat.atacar((IDaniable) mapa.getElemento(3, 3, 0));

		Assert.assertEquals(
				((Controlable) mapa.getElemento(3, 3, 0)).vidaActual(), 488);

		for (int i = 1; i <= 40; i++)
			golliat.atacar((IDaniable) mapa.getElemento(3, 3, 0));

		Assert.assertEquals(
				((Controlable) mapa.getElemento(3, 3, 0)).vidaActual(), 8);

		golliat.atacar((IDaniable) mapa.getElemento(3, 3, 0));

		Assert.assertEquals(mapa.getElemento(3, 3, 0), new Tierra());
		Assert.assertEquals(0.0, mapa.getPoblacionTotal(), 0.0);
	}

}
