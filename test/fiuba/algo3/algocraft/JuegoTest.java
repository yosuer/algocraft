package fiuba.algo3.algocraft;

import org.junit.Assert;
import org.junit.Test;

public class JuegoTest {
	
	@Test
	public void test01_crearJuego()
	{
		Juego algoCraft = new Juego();
	}
	
	@Test
	public void test02_agregarJugador()
	{
		Juego algoCraft = new Juego();
		Jugador jugador = new Jugador("Martin");
		algoCraft.agregarJugador(jugador);
		Assert.assertEquals(algoCraft.cantidadDeJugadores(),1);
		
	}
	
	@Test
	public void test03_sePermiteAgregarDosJugadoresConDistintoNombre(){
		Juego algoCraft = new Juego();
		Jugador jugador1 = new Jugador("Martin");
		algoCraft.agregarJugador(jugador1);
		
		Jugador jugador2 = new Jugador("Juan");
		algoCraft.agregarJugador(jugador2);
		Assert.assertEquals(algoCraft.cantidadDeJugadores(),2);
	}
	
	@Test
	public void test04_noSePermiteAgregarDosJugadoresConMismoNombre(){
		Juego algoCraft = new Juego();
		Jugador jugador1 = new Jugador("Martin");
		algoCraft.agregarJugador(jugador1);
		
		Jugador jugador2 = new Jugador("Martin");
		algoCraft.agregarJugador(jugador2);
		Assert.assertEquals(algoCraft.cantidadDeJugadores(),1);
	}
	
	@Test
	public void test05_agregarMapaAlJuego() {
		Juego algoCraft = new Juego();
		algoCraft.agregarMapa(new Mapa());
		
	}

}
