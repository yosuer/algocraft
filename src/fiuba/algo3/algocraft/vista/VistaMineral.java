package fiuba.algo3.algocraft.vista;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.natural.Mineral;

public class VistaMineral extends VistaIElemento {

	public VistaMineral(VistaMapa mapa, Mineral mineral) {
		super(mineral);
		acciones.add(new JButton("Mineral 1"));
	}

}
