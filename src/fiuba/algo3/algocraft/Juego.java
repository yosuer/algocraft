package fiuba.algo3.algocraft;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.vista.VentanaInicial;
import fiuba.algo3.algocraft.vista.VentanaJuego;
import fiuba.algo3.algocraft.vista.VistaIElemento;
import fiuba.algo3.algocraft.vista.VistaMapa;
import fiuba.algo3.algocraft.vista.vistasModelo.VistaBarraca;
import fiuba.algo3.algocraft.vista.vistasModelo.VistaCentroDeMando;
import fiuba.algo3.algocraft.vista.vistasModelo.VistaCentroDeMineral;
import fiuba.algo3.algocraft.vista.vistasModelo.VistaDepositoDeSuministros;
import fiuba.algo3.algocraft.vista.vistasModelo.VistaMarine;
import fiuba.algo3.algocraft.vista.vistasModelo.VistaMineral;
import fiuba.algo3.algocraft.vista.vistasModelo.VistaTierra;
import fiuba.algo3.algocraft.vista.vistasModelo.VistaVespeno;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class Juego {

	private VentanaJuego ventanaJuego;
	private JFrame ventanaInicial;
	private GameLoop gameLoop;
	private IMapa mapa;
	private VistaMapa vistaMapa;

	public Juego() {
		cargarVistas();
		initialize();
	}

	private void cargarVistas() {
		try {
			VistaIElemento.vistasElementos.put("Tierra", new VistaTierra());
			VistaIElemento.vistasElementos.put("Mineral", new VistaMineral());
			VistaIElemento.vistasElementos.put("Vespeno", new VistaVespeno());
			VistaIElemento.vistasElementos.put("CentroDeMando",
					VistaCentroDeMando.class.newInstance());
			VistaIElemento.vistasElementos.put("Barraca",
					VistaBarraca.class.newInstance());
			VistaIElemento.vistasElementos.put("DepositoDeSuministros",
					VistaDepositoDeSuministros.class.newInstance());
			VistaIElemento.vistasElementos.put("CentroDeMineral",
					VistaCentroDeMineral.class.newInstance());
			VistaIElemento.vistasElementos.put("Marine",
					VistaMarine.class.newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initialize() {
		mapa = new Mapa(40, 25);
		vistaMapa = new VistaMapa(mapa);
		gameLoop = new GameLoop((SuperficieDeDibujo) vistaMapa);
		ventanaInicial = new VentanaInicial(this);
		ventanaJuego = new VentanaJuego(vistaMapa);
		vistaMapa.agregarEnGameLoop(gameLoop);
		gameLoop.agregar(ventanaJuego.panelEstado);
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
