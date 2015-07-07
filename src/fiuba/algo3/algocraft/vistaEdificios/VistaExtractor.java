package fiuba.algo3.algocraft.vistaEdificios;

import java.io.IOException;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Extractor;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaExtractor extends VistaIElemento {

	public VistaExtractor(){
		this.elemento = new Extractor();
		this.armarImagen();
	}

}
