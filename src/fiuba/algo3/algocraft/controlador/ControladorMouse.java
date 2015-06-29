package fiuba.algo3.algocraft.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fiuba.algo3.algocraft.vista.VistaIElemento;

public class ControladorMouse extends MouseAdapter {

	VistaIElemento vista;

	public ControladorMouse(VistaIElemento vista) {
		this.vista = vista;
	}

	public void mousePressed(MouseEvent mouseEvent) {

		// Ojo al piojo.
		// El manejo de las coordenadas del mouse debe ser encapsulado por la
		// clase Posicion
		// modelo.inicializarModeloDato(new Posicion(mouseEvent.getX(),
		// mouseEvent.getY()));

		// modelo.setModeloDato(vista.posicion);
	}

}
