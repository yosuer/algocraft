package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.ExtractorDeMineral;
import fiuba.algo3.algocraft.modelo.Protoss;

public class NexoMineral extends ExtractorDeMineral 
							implements ElementoProtoss {

	public NexoMineral() {
		this.nombre = "NexoMineral";
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.estadoFisico = new Protoss(250,250);
		this.estado = new Construyendose(this, 4);
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
