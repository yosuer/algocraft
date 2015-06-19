package fiuba.algo3.algocraft.vista;

import java.awt.Color;

import fiuba.algo3.algocraft.modelo.ObjetoMultiforma;
import fiuba.algo3.titiritero.dibujables.Circulo;

public class VistaObjetoMultiforma extends Circulo {

	public VistaObjetoMultiforma(ObjetoMultiforma modelo) {
		super(20, modelo);
	}
	
	@Override
	public Color getColor() {
		//System.out.println("GetColor");
		ObjetoMultiforma objeto = (ObjetoMultiforma)this.getPosicionable();
		//System.out.println(objeto.getEstado());
		switch (objeto.getEstado()) {
		case 0:
			return Color.BLUE;
		case 1:
			return Color.RED;
		default:
			return Color.YELLOW;
		}
	}

}
