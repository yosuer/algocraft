package fiuba.algo3.algocraft.modelo.natural;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.modelo.ExtractorDeMineral;
import fiuba.algo3.algocraft.modelo.IExtractorDeRecursos;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Recurso;

public class Mineral extends Recurso {

	private ExtractorDeMineral extractor;
	
	public Mineral() {
		this.reserva = 200;
		this.nombre = "Mineral";
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
		return 0;
	}

	@Override
	public void asignarExtractor(IExtractorDeRecursos ext) {
		
		if ( this.posicion.equals(ext.getPosicion()) ){
			try {
				//if (this.extractor != null) throw new ErrorPosicionOcupada();
				this.extractor = (ExtractorDeMineral)ext;
				ext.asignarRecurso(this);
			} catch (ClassCastException e){
				throw new ErrorExtractorDeRecursosIncompatible();
			} 
		}
	}

	@Override
	public IExtractorDeRecursos getExtractor() {
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
	
	public void ejecutarAcciones(){
	}
	
}
