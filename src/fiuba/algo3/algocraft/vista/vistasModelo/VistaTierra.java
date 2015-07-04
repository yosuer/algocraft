package fiuba.algo3.algocraft.vista.vistasModelo;

import fiuba.algo3.algocraft.modelo.natural.Tierra;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaTierra extends VistaIElemento {

	public VistaTierra() {
		elemento = new Tierra();
		armarImagen();
	}
}
