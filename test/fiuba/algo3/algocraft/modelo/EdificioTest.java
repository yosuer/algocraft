package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class EdificioTest {

	@Test
	public void IgualdadDeEdificios() {
		Mapa mapa = new Mapa();
		Edificio barraca1 = new Barraca(mapa);
		Edificio barraca2 = new Barraca(mapa);
		Edificio acceso1 = new Acceso(mapa);
		Edificio acceso2 = new Acceso(mapa);
		
		Assert.assertEquals(barraca1, barraca2);
		Assert.assertNotEquals(barraca1, acceso1);
		Assert.assertEquals(acceso1, acceso2);
	}
	
	
	@Test
	public void IgualDeEdificiosConContainsAll() {
		Mapa mapa = new Mapa();
		Edificio barraca1 = new Barraca(mapa);
		Edificio acceso1 = new Acceso(mapa);
		Edificio reserva = new ReservaDeReproduccion(mapa);
		
		Edificio barraca2 = new Barraca(mapa);
		Edificio acceso2 = new Acceso(mapa);
		
		Collection<Edificio> edificiosTotales = new ArrayList<Edificio>();
		edificiosTotales.add(barraca1);
		edificiosTotales.add(acceso1);
		
		Collection<Edificio> edificiosABuscar = new ArrayList<Edificio>();
		edificiosABuscar.add(barraca2);
		edificiosABuscar.add(acceso2);

		Assert.assertTrue(edificiosTotales.containsAll(edificiosABuscar));
		
		edificiosABuscar.add(reserva);
		Assert.assertFalse(edificiosTotales.containsAll(edificiosABuscar));
		
		edificiosTotales.add(new ReservaDeReproduccion(mapa));
		Assert.assertTrue(edificiosTotales.containsAll(edificiosABuscar));
		
		edificiosABuscar.clear();;
		Assert.assertTrue(edificiosTotales.containsAll(edificiosABuscar));
	}
	

}
