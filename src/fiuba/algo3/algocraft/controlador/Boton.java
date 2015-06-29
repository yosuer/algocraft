package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Boton extends JButton {

	private static final long serialVersionUID = 8962906029783975011L;

	ControladorBotones controlador;
	
	public Boton(String label, ActionListener controlador){
		super(label);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.addActionListener(controlador);
	}
	
	

}
