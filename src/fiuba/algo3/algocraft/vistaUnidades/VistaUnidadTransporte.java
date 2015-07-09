package fiuba.algo3.algocraft.vistaUnidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Boton;
import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.controlador.acciones.Descargar;
import fiuba.algo3.algocraft.controlador.acciones.Mover;
import fiuba.algo3.algocraft.controlador.acciones.Transportar;
import fiuba.algo3.algocraft.vista.Log;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public abstract class VistaUnidadTransporte extends VistaIElemento implements
		ActionListener {

	JButton btnMover = new Boton("Mover", new Mover());
	JButton btnTransportar = new Boton("Transportar");
	JButton btnDescargar = new Boton("Descargar");

	public VistaUnidadTransporte() {

		acciones.add(btnMover);
		acciones.add(btnTransportar);
		acciones.add(btnDescargar);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand() == "Transportar")
			ControladorMapa.accion = new Transportar(ControladorMapa.select);

		if (event.getActionCommand() == "Descargar") {
			new Descargar(ControladorMapa.select);
			ControladorMapa.accion = null;
		}

		Log.loguear(event.getActionCommand());
	}

}
