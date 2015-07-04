package fiuba.algo3.algocraft.vista.vistasModelo;

import fiuba.algo3.algocraft.modelo.natural.Mineral;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaMineral extends VistaIElemento {

	public VistaMineral() {
		elemento = new Mineral();
		armarImagen();
	}

}
