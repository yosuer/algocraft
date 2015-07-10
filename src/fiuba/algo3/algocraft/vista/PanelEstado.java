package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.modelo.Equipo;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.modelo.ObjetoActualizable;

public class PanelEstado extends JPanel implements ObjetoActualizable {

	private static final long serialVersionUID = 1L;

	private JLabel infoJuego;
	private Font fuenteInfoJug;
	private IMapa mapa;
	private Equipo jugador;

	public PanelEstado(IMapa mapa) {
		this.setBackground(Color.WHITE);
		this.mapa = mapa;

		fuenteInfoJug = new Font("Verdana", Font.BOLD, 14);

		infoJuego = new JLabel("_");
		infoJuego.setFont(fuenteInfoJug);

		actualizarInfo();

		add(infoJuego);

	}

	public void actualizarInfo() {
		jugador = mapa.getEquipoActual();
		infoJuego.setText("Jugador: " + jugador.getNombre()
				+ "  |  Poblacion: " + jugador.getPoblacionTotal() + "/"
				+ jugador.getPoblacionDisponible() + "  |  Mineral: "
				+ jugador.getMineralTotal() + "/Vespeno: "
				+ jugador.getVespenoTotal() + "  |  Unidades: "
				+ jugador.cantidadElementos());
	}

	@Override
	public void actualizar() {
		actualizarInfo();
		verificarFin();
	}

	private void verificarFin() {
		if (jugador.cantidadElementos() == 0) {
			new VentanaFinJuego(jugador);

		}

	}

}
