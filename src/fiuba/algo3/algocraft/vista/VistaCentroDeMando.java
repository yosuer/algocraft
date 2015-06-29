package fiuba.algo3.algocraft.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;

public class VistaCentroDeMando extends VistaIElemento implements
		ActionListener {

	private CentroDeMando centroDeMando;
	private JButton btnCrearCentroMineral;

	public VistaCentroDeMando(VistaMapa mapa, CentroDeMando e)
			throws IOException {
		super(mapa, e);
		centroDeMando = e;
		btnCrearCentroMineral = new JButton("CrearCentroMineral");
		btnCrearCentroMineral.addActionListener(this);
	}

	public Collection<JButton> getBotones() {
		return botones;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		new CentroDeMineral();
	}

}
