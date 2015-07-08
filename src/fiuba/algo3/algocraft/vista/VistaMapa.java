package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.GridLayout;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;

public class VistaMapa extends SuperficiePanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IMapa mapa;

	private VistaCasillero[][] casilleros;
	private int ancho;
	private int largo;

	public VistaMapa(final IMapa mapa) {
		this.mapa = mapa;
		ancho = mapa.ancho();
		largo = mapa.largo();
		setMinimumSize(new Dimension(ancho * 22, largo * 22));
		casilleros = new VistaCasillero[ancho + 1][largo + 1];
		addMouseListener(new ControladorMapa(this));
		setLayout(new GridLayout(mapa.ancho(), mapa.largo()));
	}

	public void agregarEnGameLoop(GameLoop gameLoop) {
		for (int x = 1; x <= mapa.ancho(); x++) {
			for (int y = 1; y <= mapa.largo(); y++) {
				casilleros[x][y] = new VistaCasillero(mapa, x, y);
				gameLoop.agregar(casilleros[x][y]);
			}
		}
	}

	public VistaCasillero getCasillero(int x, int y) {
		return casilleros[x][y];
	}

	public IMapa getModelo() {
		return this.mapa;
	}
}
