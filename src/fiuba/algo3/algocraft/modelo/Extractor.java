package fiuba.algo3.algocraft.modelo;


public class Extractor extends ExtractorDeGasVespeno {

	private int recolectado;
	private Vespeno recurso;

	public Extractor() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 7;
	}

	@Override
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Vespeno)recurso;
	}

}
