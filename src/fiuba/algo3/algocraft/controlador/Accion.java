package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.IElemento;

public abstract class Accion implements ActionListener {

	protected IElemento elemento;

	public void setElemento(IElemento elemento) {
		this.elemento = elemento;
	}
}
