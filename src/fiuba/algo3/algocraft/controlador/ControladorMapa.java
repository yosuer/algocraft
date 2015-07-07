package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.IAtacante;
import fiuba.algo3.algocraft.modelo.IDaniable;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.vista.PanelEstado;
import fiuba.algo3.algocraft.vista.VentanaJuego;
import fiuba.algo3.algocraft.vista.VistaIElemento;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class ControladorMapa extends MouseAdapter {

	private VistaMapa mapa;
	private Posicion posicion;
	// public static VistaCasillero seleccionado;
	public static IElemento select;

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
			if (VistaMapa.seleccionar)
				seleccionar(x, y);
			else if (VistaMapa.construir)
				construir(x, y);
			else if (VistaMapa.mover)
				mover(x, y);
			else if (VistaMapa.atacar)
				atacar(x, y);
		}
	}

	private void mover(int x, int y) {
		VentanaJuego.panelAcciones.limpiar();
		Unidad unidad = (Unidad) select;
		unidad.mover(x, y);
		act();
	}

	public void seleccionar(int x, int y) {
		select = mapa.getCasillero(x, y).getVisible();
		VistaIElemento v = VistaIElemento.vistasElementos.get(select.nombre());

		VentanaJuego.panelAcciones.actualizar(v);
		act();
	}

	public void construir(int x, int y) {
		// PanelEstado.log.append("Const " + VistaMapa.aConstruir.nombre() + " "
		// + x + "," + y + PanelEstado.newline);
		try {
			mapa.getModelo().agregarElemento(x, y, VistaMapa.aConstruir);
		} catch (ErrorExtractorDeRecursosIncompatible e) {
			PanelEstado.log.append("Error al construir" + PanelEstado.newline);
		} catch (ErrorRecursosInsuficientes e) {
			PanelEstado.log.append("Recursos Insuficientes"
					+ PanelEstado.newline);
		}

		select = null;
		VistaMapa.aConstruir = null;
		VentanaJuego.panelAcciones.limpiar();
		act();
	}

	public void atacar(int x, int y) {
		try {
			IDaniable obj = (IDaniable) mapa.getModelo().getElemento(x, y, 0);
			((IAtacante) select).atacar(obj);
		} catch (ErrorObjetivoFueraDelAlcance e) {
			PanelEstado.log.append("Fuera de alcance" + PanelEstado.newline);
		}
		act();
	}

	private void act() {
		VistaMapa.seleccionar = true;
		VistaMapa.atacar = false;
		VistaMapa.construir = false;
		VistaMapa.mover = false;
	}

}
