package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ExtractorDeMineral;
import fiuba.algo3.algocraft.modelo.Zerg;


public class ZergMineral extends ExtractorDeMineral {

	public ZergMineral() {
		this.nombre = "ZergMineral";
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.estadoFisico = new Zerg(500);
		this.estado = new Construyendose(this, 4);
	}

}
