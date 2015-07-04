package fiuba.algo3.algocraft.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;

public class VistaCentroDeMando extends VistaIElemento implements
		ActionListener {

	private CentroDeMando centroDeMando;
	private JButton btnCrearCentroMineral;

	public VistaCentroDeMando(VistaMapa mapa, CentroDeMando e) {
		super(e);
		centroDeMando = e;
		btnCrearCentroMineral = new JButton("CrearCentroMineral");
		btnCrearCentroMineral.addActionListener(this);
		acciones.add(new JButton("centroMineral 1"));
		acciones.add(new JButton("centroMineral 2"));
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		new CentroDeMineral();
	}

}
