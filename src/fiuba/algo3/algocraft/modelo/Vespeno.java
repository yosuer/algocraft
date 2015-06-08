package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;

public class Vespeno extends Recurso implements IElemento {

	public Vespeno() {
		this.reserva = 1000;
		this.nivel = 0;
	}

	private int reserva;
	private ExtractorDeGasVespeno extractor;


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

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
}
