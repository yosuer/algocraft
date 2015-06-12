package fiuba.algo3.algocraft.modelo;


public class Refineria extends ExtractorDeGasVespeno {

	public Refineria() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 6;
		this.estadoFisico = new Terran(750);
	}

}
