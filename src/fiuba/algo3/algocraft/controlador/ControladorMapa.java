package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;

public class ControladorMapa {

	private IMapa mapa;
	private Posicion posicion;

	public ControladorMapa(IMapa mapa) {
		this.mapa = mapa;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	private class EscuchaBotonConstruirCentroDeMineral implements
			ActionListener {
		public void actionPerformed(ActionEvent e) {
			mapa.agregarElemento(posicion.x(), posicion.y(),
					new CentroDeMineral());
		}
	}

	public ActionListener getListenerBotonBajar() {
		return new EscuchaBotonConstruirCentroDeMineral();
	}

}
