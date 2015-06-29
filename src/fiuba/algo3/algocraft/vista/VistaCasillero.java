package fiuba.algo3.algocraft.vista;

import javax.swing.JPanel;

import fiuba.algo3.algocraft.modelo.IElemento;

public class VistaCasillero extends JPanel {

	private int x;
	private int y;

	VistaIElemento elementoAereo;
	VistaIElemento elementoTerrestre;

	public VistaCasillero(IElemento elemento, int x, int y) {
		this.x = x;
		this.y = y;
		// if (elemento.getNivel() == 0)
		elementoTerrestre = new VistaIElemento(elemento);
	}

}
