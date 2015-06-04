package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.modelo.Posicion;

public class IntegrationTest {

	@Test
	public void test_IniciarJuegoCon2JugadoresDeDistintoNombre() {
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

		Assert.assertEquals(200, juan.mineral()); 
		Assert.assertEquals(200, pedro.mineral());
		
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

		Assert.assertEquals(200, juan.mineral()); Assert.assertEquals(200, pedro.mineral());
		
		starcraft.agregarEdificioAlMapa(juan.getExtractorDeMineral(new Posicion(2, 4)));

		Assert.assertEquals(150, juan.mineral()); Assert.assertEquals(200, pedro.mineral());
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
