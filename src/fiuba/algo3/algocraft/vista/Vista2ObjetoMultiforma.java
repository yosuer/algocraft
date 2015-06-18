package fiuba.algo3.algocraft.vista;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class Vista2ObjetoMultiforma extends Cuadrado {

	public Vista2ObjetoMultiforma(ObjetoPosicionable modelo) {
		super(30, 10, modelo);
		this.setColor(Color.GREEN);
	}

}
