package fiuba.algo3.algocraft.vistaEdificios;

import java.io.IOException;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Refineria;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaRefineria extends VistaIElemento {

	public VistaRefineria(){
		this.elemento = new Refineria();
		this.armarImagen();
	}

}
