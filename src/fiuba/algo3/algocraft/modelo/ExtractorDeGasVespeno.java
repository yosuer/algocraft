package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;
import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;

public abstract class ExtractorDeGasVespeno extends Edificio 
											implements IExtractorDeRecursos{

	protected Vespeno recurso;
	protected int recolectado = 0;
	
	public int getRecolectado(){
		return this.recolectado;
	}
	
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Vespeno) recurso;
	}
	
	public void agregarseEn(Mapa mapa){
		try {
		Recurso vespeno = 
				(Recurso) mapa.getElemento(posicion.x(), posicion.y(), posicion.z());
		vespeno.asignarExtractor(this);
		} catch (ErrorExtractorDeRecursosIncompatible e) {
			throw new ErrorAgregandoElementoAlMapa();
		} catch (RuntimeException e) {
			throw new ErrorAgregandoElementoAlMapa();
		}
		this.mapa = mapa;
	}
	
	@Override
	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public void ejecutarAcciones(){
		this.depositarRecolectado();
		this.realizarExtraccion();
	}

	public void depositarRecolectado() {
		this.mapa.recibirVespeno(this.recolectado);
		this.recolectado = 0;
	}
	
	public void realizarExtraccion(){
		this.recolectado += recurso.extraer();
	}
}
