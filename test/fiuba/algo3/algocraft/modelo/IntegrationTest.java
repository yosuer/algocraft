package fiuba.algo3.algocraft.modelo;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.Protoss;
import fiuba.algo3.algocraft.Terran;
import fiuba.algo3.algocraft.modelo.Posicion;

public class IntegrationTest {

	@Test
	public void test_IniciarJuegoCon2JugadoresDeDistintoNombreYVerificarCondicionesIniciales() {
		Juego.resetInstance();
		Juego starcraft = Juego.getInstance();

		Jugador juan = new Jugador("Juan");
		juan.asignarRaza(Terran.getInstance());
		starcraft.agregarJugador(juan);

		Jugador pedro = new Jugador("Pedro");
		pedro.asignarRaza(Protoss.getInstance());
		starcraft.agregarJugador(pedro);

		starcraft.iniciarJuego();
		
		Assert.assertEquals(juan.poblacion(),5);
		Assert.assertEquals(pedro.poblacion(),5);
		Assert.assertEquals(juan, starcraft.getJugadorActual());
		Assert.assertEquals(juan.mineral(),200);
		Assert.assertEquals(pedro.mineral(),200);
		Assert.assertEquals(juan.vespeno(),0);
		Assert.assertEquals(pedro.vespeno(),0);
	}

	@Test
	public void test02_CrearUnExtractorDeMineralReduceEn50ElMineralDelJugador() {
		Juego.resetInstance();
		Juego starcraft = Juego.getInstance();

		// Creacion de jugadores
		Jugador juan = new Jugador("Juan");
		juan.asignarRaza(Terran.getInstance());
		starcraft.agregarJugador(juan);

		Jugador pedro = new Jugador("Pedro");
		pedro.asignarRaza(Protoss.getInstance());
		starcraft.agregarJugador(pedro);

		starcraft.iniciarJuego();
		
		starcraft.agregarEdificioAlMapa(juan.getExtractorDeMineral(new Posicion(2, 4)));
		
		Assert.assertEquals(150, juan.mineral()); 
		Assert.assertEquals(200, pedro.mineral());
	}
	
	@Test
	public void test02_CrearUnE() {
		Juego.resetInstance();
		Juego starcraft = Juego.getInstance();

		// Creacion de jugadores
		Jugador juan = new Jugador("Juan");
		juan.asignarRaza(Terran.getInstance());
		starcraft.agregarJugador(juan);

		Jugador pedro = new Jugador("Pedro");
		pedro.asignarRaza(Protoss.getInstance());
		starcraft.agregarJugador(pedro);

		starcraft.iniciarJuego();

		starcraft.agregarEdificioAlMapa(juan.getExtractorDeMineral(new Posicion(2, 4)));
		
		

	}
	
	@Test
	public void test03_CrearUnaUnidadReduceLosRecursosDelJugadorSegunLaUnidad(){
		Juego.resetInstance();
		Juego starcraft = Juego.getInstance();

		// Creacion de jugadores
		Jugador juan = new Jugador("Juan");
		juan.asignarRaza(Terran.getInstance());
		starcraft.agregarJugador(juan);

		Jugador pedro = new Jugador("Pedro");
		pedro.asignarRaza(Protoss.getInstance());
		starcraft.agregarJugador(pedro);

		starcraft.iniciarJuego();
		
	}
	
	
}
