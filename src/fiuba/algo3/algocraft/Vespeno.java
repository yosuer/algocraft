package fiuba.algo3.algocraft;

public class Vespeno extends Elemento implements Recurso {

	private Posicion posicion;
	private int reserva;
	private ExtractorDeGasVespeno extractor;

	public Vespeno(Posicion posicion) {
		super(posicion);
		this.reserva = 5000;
	}

	@Override
	public int reservaDisponible() {
		return this.reserva;
	}

	@Override
	public int extraer() {
		if (this.reserva > 0) {
			this.reserva-=10;
			return 10;
		}
		else return 0;
	}

	@Override
	public void asignarExtractor(ExtractorDeRecursos extractor) {
	}

	@Override
	public ExtractorDeMineral getExtractor() {
		return new CentroDeMineral(posicion);
	}
	
}
