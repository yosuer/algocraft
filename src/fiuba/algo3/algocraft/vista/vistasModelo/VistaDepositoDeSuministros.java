package fiuba.algo3.algocraft.vista.vistasModelo;

import fiuba.algo3.algocraft.modelo.edificios.DepositoDeSuministros;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaDepositoDeSuministros extends VistaIElemento {
	public VistaDepositoDeSuministros() {
		elemento = new DepositoDeSuministros();
		armarImagen();
	}
}
