package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;
import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
import fiuba.algo3.algocraft.excepciones.PosicionOcupada;


public abstract class ExtractorDeMineral extends Edificio 
										implements ExtractorDeRecursos{

	protected Mineral recurso;
	protected int recolectado;
	protected int costoMineral;
	protected int costoVespeno;
	
	public ExtractorDeMineral(){
	}

	public void realizarExtraccion(){
		recolectado += recurso.extraer();
	}

	public int getRecoleccion(){
		return recolectado;
	}
	
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Mineral) recurso;
	}

	public int getCostoMineral(){
		return costoMineral;
	}
	
	public int getCostoVespeno(){
		return costoVespeno;
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
