package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.edificios.Barraca;

public class EquipoTest {
	
	@Test
	public void test01_CrearEquipoConNombre(){
		Equipo equipo = new Equipo("algoJug1");
		
		Assert.assertEquals("algoJug1",equipo.getNombre());
	}
	
	@Test
	public void test02_DefinirElMapaDelEquipo(){
		Equipo equipo = new Equipo("jug1");
		Mapa mapa = new Mapa();
		
		equipo.setMapa(mapa);
	}
	
	@Test
	public void test03_AgregarElementoAlEquipo(){
		Equipo equipo = new Equipo("jug1");
		Mapa mapa = new Mapa();
		equipo.setMapa(mapa);
		
		mapa.agregarElemento(1, 1, new Barraca());
		
		Assert.assertEquals(1,equipo.cantidadElementos());
	}
}
