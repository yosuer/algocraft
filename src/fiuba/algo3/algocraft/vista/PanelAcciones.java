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
	private VistaIElemento elemento;

	public PanelAcciones() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setMaximumSize(new Dimension(20, 70));
	}

	public void actualizar(VistaIElemento v) {
		if (elemento == null
				|| !v.getElemento().nombre()
						.equals(elemento.getElemento().nombre())) {
			this.elemento = v;
			Collection<JButton> acciones = v.getBotones();
			this.removeAll();
			for (JButton b : acciones) {
				add(b);
				System.out.println("add boton");
			}
			this.repaint();
		}

	}

}
