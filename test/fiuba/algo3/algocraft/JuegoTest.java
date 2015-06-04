package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorCantidadDeJugadoresInvalida;
import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.modelo.Mapa;

public class JuegoTest {
	
	@Test
	public void test01_crearJuego()
	{
		Juego.resetInstance();
		Juego algoCraft = Juego.getInstance();
	}
	
	@Test
	public void test02_agregarJugador()
	{
		Juego.resetInstance();
		Juego algoCraft = Juego.getInstance();
		Jugador jugador = new Jugador("Martin");
		algoCraft.agregarJugador(jugador);
		Assert.assertEquals(algoCraft.cantidadDeJugadores(),1);
		
	}
	
	@Test
	public void test03_sePermiteAgregarDosJugadoresConDistintoNombre(){
		Juego.resetInstance();
		Juego algoCraft = Juego.getInstance();
		Jugador jugador1 = new Jugador("Martin");
		algoCraft.agregarJugador(jugador1);
		
		Jugador jugador2 = new Jugador("Juan");
		algoCraft.agregarJugador(jugador2);
		Assert.assertEquals(algoCraft.cantidadDeJugadores(),2);
	}
	
	@Test
	public void test04_noSePermiteAgregarDosJugadoresConMismoNombre(){
		Juego.resetInstance();
		Juego algoCraft = Juego.getInstance();
		Jugador jugador1 = new Jugador("Martin");
		algoCraft.agregarJugador(jugador1);
		
		Jugador jugador2 = new Jugador("Martin");
		algoCraft.agregarJugador(jugador2);
		Assert.assertEquals(algoCraft.cantidadDeJugadores(),1);
	}
	
//	@Test
//	public void test05_agregarMapaAlJuego() {
//		Juego algoCraft = Juego.getInstance();
//		algoCraft.asignarMapa(new Mapa());
//	}

	@Test(expected = ErrorCantidadDeJugadoresInvalida.class)
	public void test06_NoSePuedeIniciarElJuegoConMenosDe2Jugadores() {
		Juego algoCraft = Juego.getInstance();
		algoCraft.iniciarJuego();
	}
}
