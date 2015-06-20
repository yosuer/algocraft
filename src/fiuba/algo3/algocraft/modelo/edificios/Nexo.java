package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.Protoss;

public class Nexo extends BasePrincipal implements ElementoProtoss {

	public Nexo() {
		this.nombre = "Estado";
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.estadoFisico = new Protoss(750,750);
		this.estado = new Construyendose(this,9);
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
