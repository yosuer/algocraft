package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;

public class NaveTransporteTerran extends Unidad {

	public NaveTransporteTerran() {
		this.transporte = 8;
		this.vision = 8;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.suministro = 2;
		this.estadoFisico = new Terran(150);
		this.estado = new Construyendose(this,7);
		this.nivel = 0;
	}

}
