package fiuba.algo3.algocraft;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.vista.VentanaInicial;
import fiuba.algo3.algocraft.vista.VentanaJuego;
import fiuba.algo3.algocraft.vista.VistaIElemento;
import fiuba.algo3.algocraft.vista.VistaMapa;
import fiuba.algo3.algocraft.vistaEdificios.VistaAcceso;
import fiuba.algo3.algocraft.vistaEdificios.VistaArchivoTemplario;
import fiuba.algo3.algocraft.vistaEdificios.VistaAsimilador;
import fiuba.algo3.algocraft.vistaEdificios.VistaBarraca;
import fiuba.algo3.algocraft.vistaEdificios.VistaCentroDeMando;
import fiuba.algo3.algocraft.vistaEdificios.VistaCentroDeMineral;
import fiuba.algo3.algocraft.vistaEdificios.VistaDepositoDeSuministros;
import fiuba.algo3.algocraft.vistaEdificios.VistaFabrica;
import fiuba.algo3.algocraft.vistaEdificios.VistaNexo;
import fiuba.algo3.algocraft.vistaEdificios.VistaNexoMineral;
import fiuba.algo3.algocraft.vistaEdificios.VistaPilon;
import fiuba.algo3.algocraft.vistaEdificios.VistaPuertoEstelarProtoss;
import fiuba.algo3.algocraft.vistaEdificios.VistaPuertoEstelarTerran;
import fiuba.algo3.algocraft.vistaEdificios.VistaRefineria;
import fiuba.algo3.algocraft.vistaNaturales.VistaMineral;
import fiuba.algo3.algocraft.vistaNaturales.VistaObstaculoTerrestre;
import fiuba.algo3.algocraft.vistaNaturales.VistaTierra;
import fiuba.algo3.algocraft.vistaNaturales.VistaVespeno;
import fiuba.algo3.algocraft.vistaUnidades.VistaAltoTemplario;
import fiuba.algo3.algocraft.vistaUnidades.VistaDragon;
import fiuba.algo3.algocraft.vistaUnidades.VistaEspectro;
import fiuba.algo3.algocraft.vistaUnidades.VistaGolliat;
import fiuba.algo3.algocraft.vistaUnidades.VistaMarine;
import fiuba.algo3.algocraft.vistaUnidades.VistaNaveCiencia;
import fiuba.algo3.algocraft.vistaUnidades.VistaNaveTransporteProtoss;
import fiuba.algo3.algocraft.vistaUnidades.VistaNaveTransporteTerran;
import fiuba.algo3.algocraft.vistaUnidades.VistaScout;
import fiuba.algo3.algocraft.vistaUnidades.VistaZealot;
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

		// Elementos Naturales
		VistaIElemento.vistasElementos.put("Tierra", new VistaTierra());
		VistaIElemento.vistasElementos.put("Mineral", new VistaMineral());
		VistaIElemento.vistasElementos.put("Vespeno", new VistaVespeno());
		VistaIElemento.vistasElementos.put("ObstaculoTerrestre",
				new VistaObstaculoTerrestre());

		// Terran
		VistaIElemento.vistasElementos.put("CentroDeMando",
				new VistaCentroDeMando());
		VistaIElemento.vistasElementos.put("Barraca", new VistaBarraca());
		VistaIElemento.vistasElementos.put("DepositoDeSuministros",
				new VistaDepositoDeSuministros());
		VistaIElemento.vistasElementos.put("CentroDeMineral",
				new VistaCentroDeMineral());
		VistaIElemento.vistasElementos.put("Marine", new VistaMarine());
		VistaIElemento.vistasElementos.put("Refineria", new VistaRefineria());
		VistaIElemento.vistasElementos.put("Fabrica", new VistaFabrica());
		VistaIElemento.vistasElementos.put("Golliat", new VistaGolliat());
		VistaIElemento.vistasElementos.put("PuertoEstelarTerran",
				new VistaPuertoEstelarTerran());
		VistaIElemento.vistasElementos.put("Espectro", new VistaEspectro());
		VistaIElemento.vistasElementos.put("NaveCiencia",
				new VistaNaveCiencia());
		VistaIElemento.vistasElementos.put("NaveTransporteTerran",
				new VistaNaveTransporteTerran());

		// Protoss
		VistaIElemento.vistasElementos.put("Nexo", new VistaNexo());
		VistaIElemento.vistasElementos.put("NexoMineral",
				new VistaNexoMineral());
		VistaIElemento.vistasElementos.put("Acceso", new VistaAcceso());
		VistaIElemento.vistasElementos.put("Pilon", new VistaPilon());
		VistaIElemento.vistasElementos.put("Asimilador", new VistaAsimilador());
		VistaIElemento.vistasElementos.put("PuertoEstelarProtoss",
				new VistaPuertoEstelarProtoss());
		VistaIElemento.vistasElementos.put("ArchivoTemplario",
				new VistaArchivoTemplario());
		VistaIElemento.vistasElementos.put("Zealot", new VistaZealot());
		VistaIElemento.vistasElementos.put("Dragon", new VistaDragon());
		VistaIElemento.vistasElementos.put("Scout", new VistaScout());
		VistaIElemento.vistasElementos.put("AltoTemplario",new VistaAltoTemplario());
		VistaIElemento.vistasElementos.put("NaveTransporteProtoss",new VistaNaveTransporteProtoss());
	}

	private void initialize() {
		mapa = new Mapa(50, 25);
		vistaMapa = new VistaMapa(mapa);
		gameLoop = new GameLoop((SuperficieDeDibujo) vistaMapa);
		ventanaInicial = new VentanaInicial(this);
		ventanaJuego = new VentanaJuego(vistaMapa);
		vistaMapa.agregarEnGameLoop(gameLoop);
		gameLoop.agregar(ventanaJuego.panelEstado);
		gameLoop.agregar(ventanaJuego.panelVidaSelect);
		gameLoop.iniciarEjecucion();
	}

	public void comenzar() {
		ventanaInicial.dispose();
		ventanaJuego.setVisible(true);
	}

	public void agregarJugadores(String jugador1, String jugador2,
			String razaJ1, String razaJ2) {
		mapa.nombreEquipo1(jugador1, razaJ1);
		mapa.nombreEquipo2(jugador2, razaJ2);
	}

	public String[] getRazas() {
		String[] razas = { "Terran", "Protoss", "Zerg" };
		return razas;
	}
}
