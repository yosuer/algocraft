package fiuba.algo3.algocraft.modelo;


public class ZergMineral extends ExtractorDeMineral {

	public ZergMineral() {
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.estadoFisico = new Zerg(500);
		this.estado = new Construyendose(this, 4);
	}

}
