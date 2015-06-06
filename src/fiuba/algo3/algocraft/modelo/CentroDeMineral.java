package fiuba.algo3.algocraft.modelo;


public class CentroDeMineral extends ExtractorDeMineral {

	public CentroDeMineral(Posicion posicion) {
		super(posicion);
		this.recolectado = 0;
		this.costoMineral = 50;
		this.costoVespeno = 0;
	}

	@Override
	public int getNivel() {
		return 0;
	}
}
