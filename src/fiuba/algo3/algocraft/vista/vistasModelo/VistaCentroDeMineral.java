package fiuba.algo3.algocraft.vista.vistasModelo;

import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaCentroDeMineral extends VistaIElemento {

	public VistaCentroDeMineral() {
		elemento = new CentroDeMineral();
		armarImagen();
	}
}
