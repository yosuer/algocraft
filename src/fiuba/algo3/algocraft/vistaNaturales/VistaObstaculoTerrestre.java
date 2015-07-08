package fiuba.algo3.algocraft.vistaNaturales;

import java.util.Collection;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.natural.ObstaculoTerrestre;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaObstaculoTerrestre extends VistaIElemento {

	public VistaObstaculoTerrestre() {
		elemento = new ObstaculoTerrestre();
		armarImagen();
	}

	@Override
	protected Collection<JButton> getBotones() {
		return acciones;
	}
}
