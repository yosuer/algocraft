package fiuba.algo3.algocraft.vistaNaturales;

import java.util.Collection;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.natural.Vespeno;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaVespeno extends VistaIElemento {

	public VistaVespeno() {
		elemento = new Vespeno();
		armarImagen();
	}

	@Override
	protected Collection<JButton> getBotones() {
		return acciones;
	}
}
