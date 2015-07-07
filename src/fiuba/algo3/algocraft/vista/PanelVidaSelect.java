package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.modelo.Controlable;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.titiritero.modelo.ObjetoActualizable;

public class PanelVidaSelect extends JPanel implements ObjetoActualizable {

	private static final long serialVersionUID = 1L;

	private Controlable elemento;
	private JLabel datosElemento;
	private Font fuenteLabel;

	public PanelVidaSelect(IElemento elemento) {
		this.setBackground(Color.RED);
		this.setMaximumSize(new Dimension(60, 20));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		fuenteLabel = new Font("Verdana", Font.BOLD, 15);
		datosElemento = new JLabel("_");
		datosElemento.setFont(fuenteLabel);
		datosElemento.setForeground(Color.WHITE);

		actualizar();

		add(datosElemento);
	}

	@Override
	public void actualizar() {
		try {
			this.elemento = (Controlable) ControladorMapa.select;
			datosElemento.setText(elemento.nombre() + "  |  "
					+ elemento.vidaActual() + "  |  Posicion: "
					+ elemento.getPosicion());
		} catch (ClassCastException e) {
			datosElemento.setText("_");
		} catch (NullPointerException e) {
		}

	}
}
