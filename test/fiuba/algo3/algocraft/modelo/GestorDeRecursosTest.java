package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;

public class GestorDeRecursosTest {
	
	@Test
	public void test01_ValidarRecursoParaCreacionDeUnidades(){
		Mapa mapa = new Mapa();
		Assert.assertEquals(200,mapa.getMineralTotal());
		
		mapa.agregarElemento(3,3, new Barraca());
		
		Barraca barraca = (Barraca) mapa.getElemento(3, 3, 0);
		for (int i=1; i<=12; i++)
			mapa.pasarTurnoMapa();
		
		barraca.crearMarine();
		
		Assert.assertEquals(0,mapa.getMineralTotal());
	}
	
	@Test (expected = ErrorRecursosInsuficientes.class)
	public void test01_ValidarRecursoParaCreacionDeMarine(){
		Mapa mapa = new Mapa();
		mapa.agregarElemento(3,3, new Barraca());
		
		Barraca barraca = (Barraca) mapa.getElemento(3, 3, 0);
		
		for (int i=1; i<=12; i++)
			mapa.pasarTurnoMapa();
		
		barraca.crearMarine();
		barraca.crearMarine();
	}
	
	@Test (expected = ErrorRecursosInsuficientes.class)
	public void test02_ValidarRecursoParaCreacionDeZealot(){
		Mapa mapa = new Mapa();
		mapa.agregarElemento(3,3, new Acceso());
		
		Acceso acceso = (Acceso) mapa.getElemento(3, 3, 0);
		
		for (int i=1; i<=12; i++)
			mapa.pasarTurnoMapa();
		
		acceso.crearZealot();
	}
}
