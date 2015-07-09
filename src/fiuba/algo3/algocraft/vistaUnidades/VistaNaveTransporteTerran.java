package fiuba.algo3.algocraft.vistaUnidades;

import fiuba.algo3.algocraft.modelo.unidades.NaveTransporteTerran;

public class VistaNaveTransporteTerran extends VistaUnidadTransporte {


	public VistaNaveTransporteTerran() {
		super();
		elemento = new NaveTransporteTerran();
		btnTransportar.addActionListener(this);
		btnDescargar.addActionListener(this);
		armarImagen();
	}

}
