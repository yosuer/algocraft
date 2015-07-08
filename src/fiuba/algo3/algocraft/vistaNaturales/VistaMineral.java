package fiuba.algo3.algocraft.vistaNaturales;

import java.util.Collection;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.natural.Mineral;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaMineral extends VistaIElemento {

	public VistaMineral() {
		elemento = new Mineral();
		armarImagen();
	}

	@Override
	protected Collection<JButton> getBotones() {
		return acciones;
	}

}
