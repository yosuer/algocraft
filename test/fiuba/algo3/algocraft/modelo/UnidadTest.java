package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class UnidadTest {
	
	@Test
	public void test01_CrearUnidadesYVerificarPropiedasBasicas(){
		
	}
	
	@Test
	public void test02_CrearUnMarinoDesdeUnaBarraca(){
		Barraca barraca = new Barraca(new Posicion(1,1));
		
		Assert.assertEquals(barraca.crearUnidad().getClass(), Marine.class);
	}
	
	@Test
	public void test03_CrearUnZealotDesdeUnaAcceso(){
		Acceso acceso = new Acceso(new Posicion(1,1));
		
		Assert.assertEquals(acceso.crearUnidad().getClass(),Zealot.class);
	}
	
	@Test
	public void test04_CrearUnZerlingDesdeUnaReservaDeReproduccion(){
		ReservaDeReproduccion creador = new ReservaDeReproduccion(new Posicion(1,1));
		
		Unidad zerling = creador.crearUnidad();
	}
}
