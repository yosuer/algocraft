package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.IMapa;

public class PasarTurno implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IMapa mapa;

	public PasarTurno(IMapa mapa) {
		this.mapa = mapa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mapa.pasarTurnoMapa();
	}
}
