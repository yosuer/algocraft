package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ExtractorDeMineral;
import fiuba.algo3.algocraft.modelo.Terran;

public class CentroDeMineral extends ExtractorDeMineral {

	public CentroDeMineral() {
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.estadoFisico = new Terran(500);
		this.estado = new Construyendose(this, 4);
	}

}
