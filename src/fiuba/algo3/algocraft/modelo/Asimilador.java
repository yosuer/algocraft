package fiuba.algo3.algocraft.modelo;


public class Asimilador extends ExtractorDeGasVespeno
							implements ElementoProtoss{

	public Asimilador() {
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 12;
		this.estadoFisico = new Protoss(450,450);
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
