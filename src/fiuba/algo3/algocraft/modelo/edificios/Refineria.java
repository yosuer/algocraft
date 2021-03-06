package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.Terran;

public class Refineria extends ExtractorDeGasVespeno {

	public Refineria() {
		this.nombre = "Refineria";
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Terran(750);
		this.estado = new Construyendose(this, 4);
	}

}
