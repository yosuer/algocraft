package fiuba.algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4332071394544166252L;

	private Container contenedor;
	private VistaMapa mapa;
	private PanelBotones botones = new PanelBotones();

	public VentanaJuego(VistaMapa mapa) {
		this.mapa = mapa;
		setSize(new Dimension(1200, 750));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());

		contenedor.add(mapa, BorderLayout.CENTER);
		contenedor.add(botones, BorderLayout.EAST);
	}
}
