package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.Accion;
import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.ITransporte;

public class Descargar extends Accion {

	private ITransporte accionador;

	public Descargar(IElemento e) {
		this.accionador = (ITransporte) e;
		this.ejecutar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public void ejecutar() {
		accionador.descargar();
		ControladorMapa.accion = null;
	}

}
