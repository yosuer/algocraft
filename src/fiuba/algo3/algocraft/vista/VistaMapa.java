package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;

public class VistaMapa extends SuperficiePanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IMapa mapa;
	public static IElemento seleccionado;
	private VistaCasillero[][] casilleros;
	private int ancho;
	private int largo;

	private boolean seleccionar = true;
	private boolean construir = false;
	private boolean atacar = false;

	public VistaMapa(final IMapa mapa) {
		this.mapa = mapa;
		ancho = mapa.ancho();
		largo = mapa.largo();
		setSize(new Dimension(ancho * 22, largo * 22));
		casilleros = new VistaCasillero[ancho + 1][largo + 1];
		seleccionado = null;
		addMouseListener(new ControladorMapa(this));
		setLayout(new GridLayout(mapa.ancho(), mapa.largo()));
	}

	public void agregarEnGameLoop(GameLoop gameLoop) {
		for (int x = 1; x <= mapa.ancho(); x++) {
			for (int y = 1; y <= mapa.largo(); y++) {
				casilleros[x][y] = new VistaCasillero(mapa, x, y);
				gameLoop.agregar(casilleros[x][y].getVisible().getElemento());
				gameLoop.agregar(casilleros[x][y]);
			}
		}
	}

	public void seleccionar() {
		this.atacar = false;
		this.construir = false;
		this.seleccionar = true;
	}

	public void atacar() {
		this.atacar = true;
		this.construir = false;
		this.seleccionar = false;
	}

	public void construir() {
		this.atacar = false;
		this.construir = true;
		this.seleccionar = false;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

	public VistaIElemento getVisible(int x, int y) {
		return casilleros[x][y].getVisible();
	}

	public VistaCasillero getCasillero(int x, int y) {
		return casilleros[x][y];
	}

	public IMapa getModelo() {
		return this.mapa;
	}
}
