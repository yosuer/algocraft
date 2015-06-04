package fiuba.algo3.algocraft;

public class CentroDeMineral extends ExtractorDeMineral {
	
	private int recolectado;
	private Mineral recurso;

	public CentroDeMineral(Posicion posicion) {
		super(posicion);
		this.recolectado = 0;
	}

	@Override
	public void realizarExtraccion() {
		int rec = recurso.extraer();
		this.recolectado = this.recolectado + rec;
	}

	@Override
	public int getRecoleccion() {
		return this.recolectado;
	}

}
