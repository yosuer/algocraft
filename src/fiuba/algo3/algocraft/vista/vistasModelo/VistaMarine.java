package fiuba.algo3.algocraft.vista.vistasModelo;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonMover;
import fiuba.algo3.algocraft.controlador.acciones.Mover;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.unidades.Marine;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaMarine extends VistaIElemento {

	private JButton btnMover;

	public VistaMarine() {
		elemento = new Marine();
		armarImagen();

		btnMover = new BotonMover("Mover", new Mover());
		acciones.add(btnMover);
	}

	protected void setModelo(IElemento elemento) {
		this.elemento = elemento;
	}

}
