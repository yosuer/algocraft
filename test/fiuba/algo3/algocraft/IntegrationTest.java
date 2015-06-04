package fiuba.algo3.algocraft;

import junit.framework.Assert;

import org.junit.Test;

public class IntegrationTest {
	
	@Test
	public void test_CrearUnMapaConRecursosPredeterminados(){
		Juego.resetInstance();
		Juego starcraft = Juego.getInstance();
		
		//Creacion de jugadores
		Jugador juan = new Jugador("Juan");
		juan.asignarRaza(Terran.getInstance());
		starcraft.agregarJugador(juan);
		
		Jugador pedro = new Jugador("Pedro");
		pedro.asignarRaza(Protoss.getInstance());
		starcraft.agregarJugador(pedro);
		
		starcraft.iniciarJuego();
		
		starcraft.agregarElementoAlMapa(juan.getExtractorDeMineral(new Posicion(2,4)));
		
		}
}
