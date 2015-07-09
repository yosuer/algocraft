package fiuba.algo3.algocraft.controlador;

import javax.swing.JButton;

public class Boton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Boton(String label, Accion controlador) {
		super(label);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.addActionListener(controlador);
	}

	public Boton(String label) {
		super(label);
		this.setAlignmentX(CENTER_ALIGNMENT);
	}
}
