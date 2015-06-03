package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;

public class Mineral extends Elemento implements Recurso {

	private int reserva;
	private ExtractorDeMineral extractor;

	public Mineral(Posicion posicion) {
		super(posicion);
		this.reserva = 200;
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
	public void asignarExtractor(ExtractorDeRecursos ext) {
			if ( this.posicion.equals(ext.getPosicion()) ){
				try {
				this.extractor = (ExtractorDeMineral)ext;
				} catch (ClassCastException e){
					throw new ErrorExtractorDeRecursosIncompatible();
				}
			}
	}

	@Override
	public ExtractorDeRecursos getExtractor() {
		return this.extractor;
	}
	

}
