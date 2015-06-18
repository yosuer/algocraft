package fiuba.algo3.algocraft.vista;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class Vista3ObjetoMultiforma extends Imagen {

	public Vista3ObjetoMultiforma(ObjetoPosicionable modelo) throws IOException {
		super(Vista3ObjetoMultiforma.class.getResource("/imagen.png"), modelo);
	}

}
