package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.Accion;
import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.modelo.IElemento;

public class CrearEdificio extends Accion {

	public CrearEdificio(IElemento edificio) {
		this.elemento = edificio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ControladorMapa.aConstruir = elemento.getClass().newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		ControladorMapa.seleccionar = false;
		ControladorMapa.construir = true;
		ControladorMapa.atacar = false;
		ControladorMapa.mover = false;
		ControladorMapa.lanzarMagiaAUnidad = false;
		ControladorMapa.lanzarMagiaAPosicion = false;
	}

}
