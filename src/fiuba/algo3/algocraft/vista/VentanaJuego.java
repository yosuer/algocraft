package fiuba.algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
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
	public Log log;

	public JPanel panelInferior;
	public JPanel panelSuperior;

	public VentanaJuego(VistaMapa mapa) {
		panelMapa = mapa;
		panelAcciones = new PanelAcciones();
		panelEstado = new PanelEstado(panelMapa.getModelo());
		panelVidaSelect = new PanelVidaSelect(ControladorMapa.select);
		log = new Log();

		Font fuentePasarTurno = new Font("Arial", Font.BOLD, 15);
		btnPasarTurno = new JButton("Pasar Turno");
		btnPasarTurno.setFont(fuentePasarTurno);
		btnPasarTurno.addActionListener(new PasarTurno(panelMapa.getModelo()));

		panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
		panelInferior.add(log);
		panelInferior.add(panelVidaSelect);

		panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
		panelSuperior.add(panelEstado);
		panelSuperior.add(btnPasarTurno);

		setSize(new Dimension(1250, 700));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		contenedor = getContentPane();
		contenedor.setLayout(new BorderLayout());
		contenedor.add(panelAcciones, BorderLayout.EAST);
		contenedor.add(panelMapa, BorderLayout.CENTER);

		contenedor.add(panelSuperior, BorderLayout.NORTH);
		contenedor.add(panelInferior, BorderLayout.SOUTH);
	}

}
