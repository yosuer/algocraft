package fiuba.algo3.algocraft.modelo;


public class ZergMineral extends ExtractorDeMineral {

	public ZergMineral() {
		this.recolectado = 0;
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
		this.estadoFisico = new Zerg(500);
	}

}
