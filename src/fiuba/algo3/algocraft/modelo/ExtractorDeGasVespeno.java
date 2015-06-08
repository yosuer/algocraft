package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;


public abstract class ExtractorDeGasVespeno extends Edificio implements ExtractorDeRecursos{

	protected Vespeno recurso;
	protected int recolectado;
	
	public ExtractorDeGasVespeno() {
	}

	public void realizarExtraccion(){
		recolectado += recurso.extraer();
	}

	public int getRecoleccion(){
		return recolectado;
	}
	
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Vespeno) recurso;
	}
	
	public void agregarseEn(Mapa mapa){
		try {
		Recurso mineral = 
				(Recurso) mapa.getElemento(posicion.x(), posicion.y(), posicion.z());
		mineral.asignarExtractor(this);
		} catch (RuntimeException e) {
			throw new ErrorAgregandoElementoAlMapa();
		}

		this.mapa = mapa;
	}
}
