package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.algocraft.vista.VentanaJuego;

public class PasarTurno implements ActionListener {

	private static final long serialVersionUID = 1L;
	private IMapa mapa;

	public PasarTurno(IMapa mapa) {
		this.mapa = mapa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ControladorMapa.aConstruir = null;
		ControladorMapa.select = null;
		ControladorMapa.accion = null;

		ControladorMapa.seleccionar = true;
		ControladorMapa.atacar = false;
		ControladorMapa.construir = false;
		ControladorMapa.mover = false;
		ControladorMapa.lanzarMagiaAUnidad = false;
		ControladorMapa.lanzarMagiaAPosicion = false;
		// /limpiar acciones
		VentanaJuego.panelAcciones.limpiar();
		mapa.pasarTurnoMapa();
	}
}
