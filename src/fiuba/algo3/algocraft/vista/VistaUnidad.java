package fiuba.algo3.algocraft.vista;

import java.util.Collection;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonAtacar;
import fiuba.algo3.algocraft.controlador.BotonMover;
import fiuba.algo3.algocraft.controlador.acciones.Atacar;
import fiuba.algo3.algocraft.controlador.acciones.Mover;

public class VistaUnidad extends VistaIElemento {

	protected JButton btnMover = new BotonMover("Mover", new Mover());;
	protected JButton btnAtacar = new BotonAtacar("Atacar", new Atacar());;

	protected Collection<JButton> getBotones() {
		acciones.add(btnMover);
		acciones.add(btnAtacar);
		return acciones;
	}
}
