package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;

import fiuba.algo3.algocraft.controlador.Accion;
import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;

public class CrearUnidad extends Accion {

	private IElementoCreador creador;

	public CrearUnidad(IElementoCreador creador) {
		this.creador = creador;
		if (this.creador != null)
			System.out.println(((IElemento) creador).nombre());
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand() == "Golliat")
			((Fabrica) ControladorMapa.select).crearGolliat();
		if (event.getActionCommand() == "Marine")
			((Barraca) ControladorMapa.select).crearMarine();
		if (event.getActionCommand() == "Zealot")
			((Acceso) creador).crearZealot();
		if (event.getActionCommand() == "Dragon")
			((Acceso) creador).crearDragon();

	}

}
