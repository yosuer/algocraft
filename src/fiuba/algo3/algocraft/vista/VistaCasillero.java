package fiuba.algo3.algocraft.vista;

import javax.swing.JPanel;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.Posicion;

public class VistaCasillero extends JPanel {

	Posicion posicion;
	VistaIElemento elementoAereo;
	VistaIElemento elementoTerrestre;

	public VistaCasillero(IElemento elemento, int x, int y) {
		// TODO Auto-generated constructor stub
	}

	public void addIElementoAereo(VistaIElemento e) {
		elementoAereo = e;
	}

	public void addIElementoTerrestre(VistaIElemento e) {
		elementoTerrestre = e;
	}

}
