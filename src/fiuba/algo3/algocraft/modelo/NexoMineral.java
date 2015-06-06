package fiuba.algo3.algocraft.modelo;


public class NexoMineral extends ExtractorDeMineral {

	public NexoMineral(Posicion posicion) {
		super(posicion);
		this.recolectado = 0;
	}

	@Override
	public int getNivel() {
		return 0;
	}

}
