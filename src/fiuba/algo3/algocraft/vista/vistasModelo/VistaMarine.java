package fiuba.algo3.algocraft.vista.vistasModelo;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.unidades.Marine;
import fiuba.algo3.algocraft.vista.VistaUnidad;

public class VistaMarine extends VistaUnidad {

	private JButton btnMover;

	public VistaMarine() {
		elemento = new Marine();
		armarImagen();
	}

}
