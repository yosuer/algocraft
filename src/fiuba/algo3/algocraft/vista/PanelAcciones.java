package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.util.Collection;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAcciones extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelAcciones() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setMaximumSize(new Dimension(20, 70));
	}

	public void actualizar(VistaIElemento v) {
		cambiarBotones(v.getBotones());
	}

	private void cambiarBotones(Collection<JButton> nuevos) {
		this.removeAll();
		for (JButton b : nuevos)
			add(b);
		this.revalidate();
		this.repaint();
	}

	public void limpiar() {
		this.removeAll();
		this.repaint();
	}

}
