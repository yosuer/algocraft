package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.Zerg;

public class Extractor extends ExtractorDeGasVespeno {

	public Extractor() {
		this.nombre = "Extractor";
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Zerg(600);
		this.estado = new Construyendose(this, 7);
	}

}
