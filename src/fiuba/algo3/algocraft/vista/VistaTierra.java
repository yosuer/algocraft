package fiuba.algo3.algocraft.vista;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;

public class VistaTierra extends VistaIElemento {

	public VistaTierra(IElemento e) {
		super(e);
		acciones.add(new JButton("Tierra 1"));
	}

}
