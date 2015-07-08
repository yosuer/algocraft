package fiuba.algo3.algocraft.vistaNaturales;

import java.util.Collection;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.natural.Tierra;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaTierra extends VistaIElemento {

	public VistaTierra() {
		elemento = new Tierra();
		armarImagen();
	}

	@Override
	protected Collection<JButton> getBotones() {
		return acciones;
	}
}
