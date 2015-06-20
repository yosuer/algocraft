package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Terran;

public class CentroDeMando extends BasePrincipal {

	public CentroDeMando() {
		this.nombre = "CentroDeMando";
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.estadoFisico = new Terran(1500);
		this.estado = new Construyendose(this,7);
	}

}
