package fiuba.algo3.algocraft.modelo;


public class Extractor extends ExtractorDeGasVespeno {

	private int recolectado;
	private Vespeno recurso;

	public Extractor(Posicion posicion) {
		super(posicion);
	}

	@Override
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Vespeno)recurso;
	}

}
