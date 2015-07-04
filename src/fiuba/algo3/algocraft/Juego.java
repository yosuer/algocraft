package fiuba.algo3.algocraft;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.vista.VentanaInicial;
import fiuba.algo3.algocraft.vista.VentanaJuego;
import fiuba.algo3.algocraft.vista.VistaMapa;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class Juego {

	private JFrame ventanaJuego;
	private JFrame ventanaInicial;
	private GameLoop gameLoop;
	private IMapa mapa;
	private VistaMapa vistaMapa;

	public Juego() {
		// VistaIElemento.vistasIElementos.put("Tierra", new VistaTierra());
		initialize();
	}

	private void initialize() {
		mapa = new Mapa(40, 30);
		vistaMapa = new VistaMapa(mapa);
		gameLoop = new GameLoop((SuperficieDeDibujo) vistaMapa);
		ventanaInicial = new VentanaInicial(this);
		ventanaJuego = new VentanaJuego(vistaMapa);
		vistaMapa.agregarEnGameLoop(gameLoop);
		gameLoop.iniciarEjecucion();
	}

	public void comenzar() {
		ventanaInicial.dispose();
		ventanaJuego.setVisible(true);
	}

	public void agregarJugadores(String jugador1, String jugador2) {
		mapa.nombreEquipo1(jugador1);
		mapa.nombreEquipo2(jugador2);
	}
}
