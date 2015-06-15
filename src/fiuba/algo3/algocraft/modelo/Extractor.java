package fiuba.algo3.algocraft.modelo;

public class Extractor extends ExtractorDeGasVespeno {

	public Extractor() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Zerg(600);
		this.estado = new Construyendose(this,7);

	}

}
