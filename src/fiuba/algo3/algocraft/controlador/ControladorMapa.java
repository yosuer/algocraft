package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.vista.VentanaJuego;
import fiuba.algo3.algocraft.vista.VistaCasillero;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class ControladorMapa extends MouseAdapter {

	private VistaMapa mapa;
	private Posicion posicion;
	private VistaCasillero seleccionado;

	public ControladorMapa(VistaMapa mapa) {
		this.mapa = mapa;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	private class EscuchaBotonConstruirCentroDeMineral implements
			ActionListener {
		public void actionPerformed(ActionEvent e) {
			mapa.getModelo().agregarElemento(posicion.x(), posicion.y(),
					new CentroDeMineral());
		}
	}

	public ActionListener getListenerBotonBajar() {
		return new EscuchaBotonConstruirCentroDeMineral();
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX() / 22 + 1;
		int y = e.getY() / 22 + 1;

		if (x <= mapa.getModelo().ancho() & y <= mapa.getModelo().largo()) {
			seleccionado = mapa.getCasillero(x, y);
			System.out.println("x: " + x + " y: " + y + "  select: "
					+ seleccionado.getVisible().getElemento().nombre());
			VentanaJuego.panelAcciones.actualizar(seleccionado.getVisible());
		}

	}

}
