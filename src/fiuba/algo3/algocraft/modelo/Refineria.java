package fiuba.algo3.algocraft.modelo;

public class Refineria extends ExtractorDeGasVespeno {

	public Refineria() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Terran(750);
		this.estado = new Construyendose(this, 4);
	}

}
