package fiuba.algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import fiuba.algo3.algocraft.controlador.acciones.PasarTurno;

public class VentanaJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4332071394544166252L;

	private Container contenedor;
	private VistaMapa panelMapa;
	public static PanelAcciones panelAcciones;
	public JButton btnPasarTurno;

	public VentanaJuego(VistaMapa mapa) {
		panelMapa = mapa;
		panelAcciones = new PanelAcciones();
		btnPasarTurno = new JButton("PasarTurno");
		btnPasarTurno.setMaximumSize(new Dimension(20, 25));
		btnPasarTurno.addActionListener(new PasarTurno(panelMapa.getModelo()));

		setSize(new Dimension(1100, 650));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());

		contenedor.add(mapa, BorderLayout.CENTER);
		contenedor.add(panelAcciones, BorderLayout.EAST);
		contenedor.add(btnPasarTurno, BorderLayout.SOUTH);
	}
}
