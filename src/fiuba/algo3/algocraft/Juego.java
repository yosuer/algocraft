package fiuba.algo3.algocraft;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.vista.VentanaJuego;
import fiuba.algo3.algocraft.vista.VentanaPrincipal;
import fiuba.algo3.algocraft.vista.VistaMapa;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class Juego {

	private JFrame ventanaJuego;
	private JFrame ventanaPrincipal;
	private GameLoop gameLoop;
	private IMapa mapa;
	private VistaMapa vistaMapa;

	public Juego() {
		initialize();
	}

	private void initialize() {
		mapa = new Mapa(40, 30);
		vistaMapa = new VistaMapa(mapa);
		ventanaPrincipal = new VentanaPrincipal(this);
		gameLoop = new GameLoop((SuperficieDeDibujo) vistaMapa);
		ventanaJuego = new VentanaJuego(vistaMapa);
		vistaMapa.agregarEnGameLoop(gameLoop);
	}

	public void comenzar() {
		ventanaJuego.setVisible(true);
		gameLoop.iniciarEjecucion();
	}

	public void agregarJugadores(String jugador1, String jugador2) {
		mapa.nombreEquipo1(jugador1);
		mapa.nombreEquipo2(jugador2);
	}
}
