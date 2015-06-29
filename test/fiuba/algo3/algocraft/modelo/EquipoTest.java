package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.edificios.Barraca;

public class EquipoTest {

	@Test
	public void test01_CrearEquipoConNombre() {
		Equipo equipo = new Equipo("algoJug1");

		Assert.assertEquals("algoJug1", equipo.getNombre());
	}

	@Test
	public void test02_DefinirElMapaDelEquipo() {
		Equipo equipo = new Equipo("jug1");
		Mapa mapa = new Mapa(40, 40);

		equipo.setMapa(mapa);
	}

	@Test
	public void test03_AgregarElementoAlEquipo() {
		Mapa mapa = new Mapa(40, 40);
		mapa.agregarElemento(1, 1, new Barraca());

		Equipo equipo = mapa.getEquipo1();

		Assert.assertEquals(1, equipo.cantidadElementos());
	}
}
