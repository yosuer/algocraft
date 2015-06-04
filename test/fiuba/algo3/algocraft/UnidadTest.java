package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.ElementoCreador;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.*;
import fiuba.algo3.algocraft.modelo.unidades.*;

public class UnidadTest {
	
	@Test
	public void test01_CrearUnidadesYVerificarPropiedasBasicas(){
		
	}
	
	@Test
	public void test02_CrearUnMarinoDesdeUnaBarraca(){
		Barraca creador = new Barraca(new Posicion(1,1));
		
		Assert.assertEquals(creador.crearElemento().getClass(),Marine.class);
	}
	
	@Test
	public void test03_CrearUnZealotDesdeUnaAcceso(){
		Acceso creador = new Acceso(new Posicion(1,1));
		
		Assert.assertEquals(creador.crearElemento().getClass(),Zealot.class);
	}
	
	@Test
	public void test04_CrearUnZerlingDesdeUnaReservaDeReproduccion(){
		ReservaDeReproduccion creador = new ReservaDeReproduccion(new Posicion(1,1));
		
		Zerling zerling = (Zerling) creador.crearElemento();
	}
}
