package fiuba.algo3.algocraft.vista;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaIElemento extends Imagen {

	public VistaIElemento(ObjetoPosicionable iElemento) throws IOException {
		super(Vista3ObjetoMultiforma.class.getResource("/imagen.png"), iElemento);
	}

}

//sprites

//atlasses