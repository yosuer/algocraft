package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
import fiuba.algo3.algocraft.modelo.Controlable;
import fiuba.algo3.algocraft.modelo.IAtacante;
import fiuba.algo3.algocraft.modelo.IDaniable;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.vista.PanelEstado;
import fiuba.algo3.algocraft.vista.VentanaJuego;
import fiuba.algo3.algocraft.vista.VistaCasillero;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class ControladorMapa extends MouseAdapter {

	private VistaMapa mapa;
	private Posicion posicion;
	public static IElemento select;
	public static IElemento aConstruir;

	public static boolean seleccionar = true;
	public static boolean construir = false;
	public static boolean atacar = false;
	public static boolean mover = false;

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
			if (seleccionar)
				seleccionar(x, y);
			else if (construir)
				construir(x, y);
			else if (mover)
				mover(x, y);
			else if (atacar)
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
		VistaCasillero casillero = mapa.getCasillero(x, y);
		select = casillero.getVisible();

		try {
			if (mapa.getModelo().getEquipoActual() == ((Controlable) select)
					.getEquipo())
				VentanaJuego.panelAcciones.actualizar(casillero
						.getVistaElementoActual());
		} catch (ClassCastException e) {
			VentanaJuego.panelAcciones.limpiar();
		}
		act();
	}

	public void construir(int x, int y) {

		try {
			mapa.getModelo().agregarElemento(x, y, aConstruir);
		} catch (ErrorExtractorDeRecursosIncompatible e) {
			PanelEstado.log.append("Error al construir" + PanelEstado.newline);
		} catch (ErrorRecursosInsuficientes e) {
			PanelEstado.log.append("Recursos Insuficientes"
					+ PanelEstado.newline);
		} catch (NoExistenLosEdificiosrequeridosParaConstruir e) {
			PanelEstado.log.append("Faltan edificios requeridos"
					+ PanelEstado.newline);
		}

		select = null;
		aConstruir = null;
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
		seleccionar = true;
		atacar = false;
		construir = false;
		mover = false;
	}

}
