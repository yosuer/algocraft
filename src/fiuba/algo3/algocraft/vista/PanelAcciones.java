package fiuba.algo3.algocraft.vista;

import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAcciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btnIniciar;
	JButton btnSalir;

	public PanelAcciones(Collection<JButton> botones) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		for (JButton b : botones)
			add(b);
	}

	public void actualizarBotones(Collection<JButton> botones) {
		this.removeAll();
		for (JButton b : botones)
			add(b);
	}

}
