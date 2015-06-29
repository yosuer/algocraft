package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBotones implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("Boton: " + e.getActionCommand() + ".");
		try {
			// modelo.selectEdificio((String)e.getActionCommand());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
