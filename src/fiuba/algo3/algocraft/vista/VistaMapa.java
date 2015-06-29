package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoDibujable;

public class VistaMapa extends SuperficiePanel {

	private IMapa mapa;
	private IElemento seleccionado;

	private boolean seleccionar = true;
	private boolean construir = false;
	private boolean atacar = false;

	public VistaMapa(final IMapa mapa) {
		this.mapa = mapa;
		setSize(new Dimension(880, mapa.largo() * 22));
		seleccionado = null;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int x = e.getX() / 22 + 1;
				int y = e.getY() / 22 + 1;

				if (x <= mapa.ancho() & y <= mapa.largo()) {
					seleccionado = mapa.getElemento(x, y, 0);
					System.out.println("x: " + x + " y: " + y + "  select: "
							+ seleccionado.nombre());
				}
			}
		});
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
}
