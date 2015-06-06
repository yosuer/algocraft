package fiuba.algo3.algocraft.modelo;


public class ZergMineral extends ExtractorDeMineral {

	public ZergMineral(Posicion posicion) {
		super(posicion);
		this.recolectado = 0;
	}

	@Override
	public int getNivel() {
		return 0;
	}

}
