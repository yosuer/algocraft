package fiuba.algo3.algocraft.controlador;

import java.awt.event.MouseAdapter;

import fiuba.algo3.algocraft.vista.VistaCasillero;

public class ControladorCasillero extends MouseAdapter {

	private VistaCasillero casillero;

	public void ControladorCasillero(VistaCasillero casillero) {
		this.casillero = casillero;
	}
}
