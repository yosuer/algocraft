package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ColaTest {
	
	@Test
	public void test01_creacionDeLaCola(){
		ListaMU<String> cola = new ListaMU<String>();
	}
	
	@Test
	public void test02_agregarYQuitarElementosDeLaCola(){
		ListaMU<String> cola = new ListaMU<String>();
		cola.encolar("a");
		cola.encolar("b");
		
		Assert.assertEquals(2,cola.size());
		Assert.assertEquals("a",cola.desEncolar());
		Assert.assertEquals("b",cola.desEncolar());
		Assert.assertEquals(0,cola.size());
	}
	
	@Test
	public void test03_pedirPrimeroEnUnaColaDevuelveElPrimerElementoAgregado(){
		ListaMU<String> cola = new ListaMU<String>();
		cola.encolar("a");
		cola.encolar("b");
		
		Assert.assertEquals(2,cola.size());
		Assert.assertEquals("a",cola.primero());
	}
}
