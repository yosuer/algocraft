package fiuba.algo3.algocraft.modelo.edificios;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Edificio;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.ReservaDeReproduccion;

public class EdificioTest {

	@Test
	public void IgualdadDeEdificios() {
		Edificio barraca1 = new Barraca();
		Edificio barraca2 = new Barraca();
		Edificio acceso1 = new Acceso();
		Edificio acceso2 = new Acceso();
		
		Assert.assertEquals(barraca1, barraca2);
		Assert.assertNotEquals(barraca1, acceso1);
		Assert.assertEquals(acceso1, acceso2);
	}
	
	
	@Test
	public void IgualDeEdificiosConContainsAll() {
		Edificio barraca1 = new Barraca();
		Edificio acceso1 = new Acceso();
		Edificio reserva = new ReservaDeReproduccion();
		
		Edificio barraca2 = new Barraca();
		Edificio acceso2 = new Acceso();
		
		Collection<Edificio> edificiosTotales = new ArrayList<Edificio>();
		edificiosTotales.add(barraca1);
		edificiosTotales.add(acceso1);
		
		Collection<Edificio> edificiosABuscar = new ArrayList<Edificio>();
		edificiosABuscar.add(barraca2);
		edificiosABuscar.add(acceso2);

		Assert.assertTrue(edificiosTotales.containsAll(edificiosABuscar));
		
		edificiosABuscar.add(reserva);
		Assert.assertFalse(edificiosTotales.containsAll(edificiosABuscar));
		
		edificiosTotales.add(new ReservaDeReproduccion());
		Assert.assertTrue(edificiosTotales.containsAll(edificiosABuscar));
		
		edificiosABuscar.clear();;
		Assert.assertTrue(edificiosTotales.containsAll(edificiosABuscar));
	}
	

}
