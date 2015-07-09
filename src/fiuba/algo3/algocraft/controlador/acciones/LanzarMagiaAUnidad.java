package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.Accion;
import fiuba.algo3.algocraft.controlador.ControladorMapa;

public class LanzarMagiaAUnidad extends Accion {

	@Override
	public void actionPerformed(ActionEvent e) {
		ControladorMapa.seleccionar = false;
		ControladorMapa.construir = false;
		ControladorMapa.atacar =false;
		ControladorMapa.mover = false;
		ControladorMapa.lanzarMagiaAUnidad = true;
		ControladorMapa.lanzarMagiaAPosicion = false;
	}

}
