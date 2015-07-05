package fiuba.algo3.algocraft.vista.vistasModelo;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonMover;
import fiuba.algo3.algocraft.controlador.acciones.Mover;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.unidades.Marine;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaMarine extends VistaIElemento {

	private JButton btnMover;
	private Mover accion;

	public VistaMarine() {
		elemento = new Marine();
		armarImagen();
		accion = new Mover(this.getElemento());
		btnMover = new BotonMover("Mover", accion);
		acciones.add(btnMover);
	}

	protected void setModelo(IElemento elemento) {
		this.elemento = elemento;
		accion.setElemento(elemento);
	}

}
