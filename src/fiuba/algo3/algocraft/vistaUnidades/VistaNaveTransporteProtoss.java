package fiuba.algo3.algocraft.vistaUnidades;

import fiuba.algo3.algocraft.modelo.unidades.NaveDeTransporteProtoss;

public class VistaNaveTransporteProtoss extends VistaUnidadTransporte {

	public VistaNaveTransporteProtoss() {
		super();
		elemento = new NaveDeTransporteProtoss();
		btnTransportar.addActionListener(this);
		btnDescargar.addActionListener(this);
		armarImagen();
	}

}
