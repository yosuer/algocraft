package fiuba.algo3.algocraft.modelo;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class GestorDeUbicacionesTest {
	
	@Test
	public void test01_ObtenerCaminos(){
		GestorDeUbicaciones gm = new GestorDeUbicaciones(10,10,1);
		Posicion inicio = new Posicion(1,1,0);
		Posicion destino = new Posicion(6,6,0);
		
		Collection<Posicion> camino = gm.getHojaDeRuta(inicio, destino);
		
		Assert.assertEquals(6, camino.size());
	}
	
	@Test
	public void test02_ObtenerDistanciasEntre2Posiciones(){
		GestorDeUbicaciones gm = new GestorDeUbicaciones(10,10,1);
		Posicion inicio = new Posicion(1,1,0);
		Posicion destino = new Posicion(2,2,0);
		
		Assert.assertEquals(1, gm.getDistancia(inicio, destino));
		Assert.assertEquals(1, gm.getDistancia(destino, inicio));
		
		inicio = new Posicion(3,3,0);
		destino = new Posicion(3,8,0);
		
		Assert.assertEquals(5, gm.getDistancia(inicio, destino));
		Assert.assertEquals(5, gm.getDistancia(destino, inicio));
		
		inicio = new Posicion(3,8,0);
		destino = new Posicion(10,8,0);
		
		Assert.assertEquals(7, gm.getDistancia(inicio, destino));
		Assert.assertEquals(7, gm.getDistancia(destino, inicio));
		
		inicio = new Posicion(3,5,0);
		destino = new Posicion(6,6,0);
		
		Assert.assertEquals(3, gm.getDistancia(inicio, destino));
		Assert.assertEquals(3, gm.getDistancia(destino, inicio));
	}

}
