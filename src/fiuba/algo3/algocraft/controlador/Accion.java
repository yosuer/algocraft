package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.vista.VistaCasillero;

public abstract class Accion implements ActionListener {

	protected IElemento elemento;

	public void setElemento(IElemento elemento) {
		this.elemento = elemento;
	}

	public void ejecutar(int x, int y) {
	}

	public void ejecutar() {
	}

	public void ejecutar(VistaCasillero v) {
	}
}
