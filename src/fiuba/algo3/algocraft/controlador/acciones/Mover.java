package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.Accion;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class Mover extends Accion {

	public Mover() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VistaMapa.seleccionar = false;
		VistaMapa.construir = false;
		VistaMapa.atacar = false;
		VistaMapa.mover = true;
	}

}
