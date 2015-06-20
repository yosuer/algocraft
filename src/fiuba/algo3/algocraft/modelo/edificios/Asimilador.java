package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.Protoss;

public class Asimilador extends ExtractorDeGasVespeno
							implements ElementoProtoss {

	public Asimilador() {
		this.nombre = "Asimilador";
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Protoss(450,450);
		this.estado = new Construyendose(this, 6);
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

}
