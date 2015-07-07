package fiuba.algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.controlador.acciones.PasarTurno;

public class VentanaJuego extends JFrame {

	private static final long serialVersionUID = -4332071394544166252L;

	private Container contenedor;
	private VistaMapa panelMapa;
	public static PanelAcciones panelAcciones;
	public PanelEstado panelEstado;
	public JButton btnPasarTurno;
	public PanelVidaSelect panelVidaSelect;
	public JPanel panelIzquierdo;
	public JPanel panelInferior;
	public LineaLog log;

	public VentanaJuego(VistaMapa mapa) {
		panelMapa = mapa;
		panelAcciones = new PanelAcciones();
		panelEstado = new PanelEstado(panelMapa.getModelo());
		panelVidaSelect = new PanelVidaSelect(ControladorMapa.select);
		log = new LineaLog();

		panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new FlowLayout());
		panelIzquierdo.add(panelEstado);

		panelInferior = new JPanel();
		panelInferior.setLayout(new FlowLayout());
		panelInferior.add(log);
		panelInferior.add(panelVidaSelect);

		btnPasarTurno = new JButton("PasarTurno");
		btnPasarTurno.setMaximumSize(new Dimension(20, 25));
		btnPasarTurno.addActionListener(new PasarTurno(panelMapa.getModelo()));

		setSize(new Dimension(1250, 650));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		contenedor.add(panelIzquierdo, BorderLayout.WEST);
		contenedor.add(panelMapa, BorderLayout.CENTER);
		contenedor.add(panelAcciones, BorderLayout.EAST);
		contenedor.add(btnPasarTurno, BorderLayout.NORTH);
		contenedor.add(panelInferior, BorderLayout.SOUTH);
	}

}
