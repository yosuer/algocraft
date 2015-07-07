package fiuba.algo3.algocraft.vistaEdificios;

import java.io.IOException;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.ZergMineral;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaZergMineral extends VistaIElemento {

	public VistaZergMineral(){
		this.elemento = new ZergMineral();
		this.armarImagen();
	}

}
