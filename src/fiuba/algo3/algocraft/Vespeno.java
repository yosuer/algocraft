package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeRecursos;

public class Vespeno extends Elemento implements Recurso {

	private int reserva;
	private ExtractorDeGasVespeno extractor;

	public Vespeno(Posicion posicion) {
		super(posicion);
		this.reserva = 5000;
		this.capa = 1;
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
				this.extractor = (ExtractorDeGasVespeno)ext;
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
