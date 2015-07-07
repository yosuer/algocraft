package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fiuba.algo3.algocraft.modelo.Equipo;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.modelo.ObjetoActualizable;

public class PanelEstado extends JPanel implements ObjetoActualizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JTextArea log;
	private JLabel nombreJugador;
	private JLabel estadoJugador;
	private JLabel estadoRecursos;
	private Font fuenteLog;
	private Font fuenteInfoJug;
	private IMapa mapa;
	private Equipo jugador;

	public final static String newline = "\n";

	public PanelEstado(IMapa mapa) {
		this.setBackground(Color.WHITE);
		this.setMaximumSize(new Dimension(60, 20));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.mapa = mapa;

		fuenteInfoJug = new Font("Verdana", Font.BOLD, 14);

		nombreJugador = new JLabel("");
		nombreJugador.setFont(fuenteInfoJug);
		estadoJugador = new JLabel("");
		estadoJugador.setFont(fuenteInfoJug);
		estadoRecursos = new JLabel();
		estadoRecursos.setFont(fuenteInfoJug);
		actualizarInfo();

		add(nombreJugador);
		add(estadoJugador);
		add(estadoRecursos);

		fuenteLog = new Font("Verdana", Font.ITALIC, 12);
		log = new JTextArea(15, 12);
		log.setFont(fuenteLog);
		log.setForeground(Color.WHITE);
		log.setEditable(false);
		log.setBackground(Color.BLACK);
		add(log);
	}

	public void actualizarInfo() {
		jugador = mapa.getEquipoActual();
		nombreJugador.setText(jugador.getNombre());
		estadoJugador.setText("Poblacion: " + jugador.getPoblacionTotal());
		estadoRecursos.setText("Min: " + jugador.getMineralTotal() + " | Ves: "
				+ jugador.getVespenoTotal());
	}

	@Override
	public void actualizar() {
		actualizarInfo();
	}

}
