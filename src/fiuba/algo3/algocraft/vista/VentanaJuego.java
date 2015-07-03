package fiuba.algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4332071394544166252L;

	private Container contenedor;
	private VistaMapa mapa;
	private PanelAcciones acciones;

	public VentanaJuego(VistaMapa mapa) {
		this.mapa = mapa;

		Collection<JButton> botones = new LinkedList<JButton>();
		botones.add(new JButton("Iniciar"));
		botones.add(new JButton("Salir"));
		acciones = new PanelAcciones(botones);

		setSize(new Dimension(1200, 750));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());

		contenedor.add(mapa, BorderLayout.CENTER);
		contenedor.add(acciones, BorderLayout.EAST);
	}
}
