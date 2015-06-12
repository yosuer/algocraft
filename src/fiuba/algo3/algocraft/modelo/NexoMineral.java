package fiuba.algo3.algocraft.modelo;

public class NexoMineral extends ExtractorDeMineral 
							implements ElementoProtoss {

	public NexoMineral() {
		this.recolectado = 0;
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
		this.estadoFisico = new Protoss(250,250);
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
