package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import fiuba.algo3.algocraft.modelo.Equipo;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.modelo.ObjetoActualizable;

public class PanelEstado extends JPanel implements ObjetoActualizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JTextArea log;
	private JLabel infoJugador;
	private Font fuenteLog;
	private Font fuenteInfoJug;
	private IMapa mapa;
	private Equipo jugador;

	public final static String newline = "\n";

	public PanelEstado(IMapa mapa) {
		this.setBackground(Color.BLUE);
		this.setMaximumSize(new Dimension(40, 200));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.mapa = mapa;

		fuenteInfoJug = new Font("Arial", Font.BOLD, 15);
		infoJugador = new JLabel();
		infoJugador.setFont(fuenteInfoJug);
		setJugadorActual();
		infoJugador.setHorizontalAlignment(SwingConstants.LEFT);
		add(infoJugador);

		fuenteLog = new Font("Verdana", Font.ITALIC, 12);
		log = new JTextArea(10, 10);
		log.setFont(fuenteLog);
		log.setForeground(Color.WHITE);
		log.setEditable(false);
		log.setBackground(Color.BLACK);
		agregarTexto("Inicio log");
		add(log);
	}

	public void agregarTexto(String texto) {
		log.append(texto + newline);
	}

	public void setJugadorActual() {
		jugador = mapa.getEquipoActual();
		infoJugador.setText(jugador.getNombre() + "  P: "
				+ jugador.getPoblacionTotal());
		infoJugador.setHorizontalAlignment(SwingConstants.LEFT);
	}

	@Override
	public void actualizar() {
		setJugadorActual();
	}

}
