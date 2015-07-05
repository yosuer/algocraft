package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.Accion;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class CrearEdificio extends Accion {

	public CrearEdificio(IElemento edificio) {
		this.elemento = edificio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			VistaMapa.aConstruir = elemento.getClass().newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		VistaMapa.seleccionar = false;
		VistaMapa.construir = true;
		VistaMapa.atacar = false;
	}

}
