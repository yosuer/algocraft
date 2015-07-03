package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;

public class ControladorMapa extends MouseAdapter {

	private IMapa mapa;
	private Posicion posicion;
	private IElemento seleccionado;

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

	public void mousePressed(MouseEvent e) {
		int x = e.getX() / 22 + 1;
		int y = e.getY() / 22 + 1;

		if (x <= mapa.ancho() & y <= mapa.largo()) {
			seleccionado = mapa.getElemento(x, y, 0);
			System.out.println("x: " + x + " y: " + y + "  select: "
					+ seleccionado.nombre());
		}
	}

}
