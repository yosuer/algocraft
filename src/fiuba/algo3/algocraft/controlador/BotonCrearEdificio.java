package fiuba.algo3.algocraft.controlador;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.acciones.CrearEdificio;

public class BotonCrearEdificio extends JButton {

	private static final long serialVersionUID = 8962906029783975011L;

	public BotonCrearEdificio(String label, CrearEdificio controlador) {
		super(label);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.addActionListener(controlador);
	}

}
