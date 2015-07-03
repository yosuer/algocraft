package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;

public class VistaMapa extends SuperficiePanel implements Observer {

	private IMapa mapa;
	private IElemento seleccionado;

	private boolean seleccionar = true;
	private boolean construir = false;
	private boolean atacar = false;

	public VistaMapa(final IMapa mapa) {
		this.mapa = mapa;
		setSize(new Dimension(880, mapa.largo() * 22));
		seleccionado = null;
		addMouseListener(new ControladorMapa(mapa));
		setLayout(new GridLayout(mapa.ancho(), mapa.largo()));
	}

	public void agregarEnGameLoop(GameLoop gameLoop) {
		try {
			for (int x = 1; x <= mapa.ancho(); x++) {
				for (int y = 1; y <= mapa.largo(); y++) {
					IElemento elemento = mapa.getElemento(x, y, 0);
					gameLoop.agregar(elemento);
					ObjetoDibujable imagen = new VistaIElemento(this, elemento);
					gameLoop.agregar(imagen);
					// add(new VistaCasillero(elemento, x, y));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
}
