package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.algocraft.vista.VistaMapa;

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
		VistaMapa.seleccionado = null;
		VistaMapa.aConstruir = null;
		VistaMapa.seleccionar = true;
		VistaMapa.atacar = false;
		VistaMapa.construir = false;
		mapa.pasarTurnoMapa();
	}
}
