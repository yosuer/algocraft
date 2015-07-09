package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.Accion;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.ITransportable;
import fiuba.algo3.algocraft.modelo.ITransporte;
import fiuba.algo3.algocraft.vista.Log;
import fiuba.algo3.algocraft.vista.VistaCasillero;

public class Transportar extends Accion {

	private ITransporte accionador;

	public Transportar(IElemento e) {
		this.accionador = (ITransporte) e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public void ejecutar(VistaCasillero v) {
		try {
			ITransportable unidad = (ITransportable) v.getVisible();
			accionador.transportar(unidad);

		} catch (ClassCastException e) {
			Log.loguear("No se puede transportar la unidad");
		}
	}
}
