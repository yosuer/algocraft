package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;
import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;

public abstract class ExtractorDeMineral extends Edificio 
										implements IExtractorDeRecursos{

	protected Mineral recurso;
	protected int recolectado = 0;

	public int getRecolectado(){
		return this.recolectado;
	}
	
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Mineral) recurso;
	}
	
	public void agregarseEn(Mapa mapa){
		mapa.gastarRecursos(costoMineral, costoVespeno);
		try {
		Recurso mineral = (Mineral) mapa.getElemento(posicion.x(), posicion.y(), posicion.z());
		mineral.asignarExtractor(this);
		} catch (ErrorExtractorDeRecursosIncompatible e) {
			throw new ErrorAgregandoElementoAlMapa();
		} catch (RuntimeException e) {
			throw new ErrorAgregandoElementoAlMapa();
		}
		this.mapa = mapa;
	}
	
	public void ejecutarAcciones(){
		this.depositarRecolectado(this.equipo);
		this.realizarExtraccion();
	}
	
	public void depositarRecolectado(Equipo equipo) {
		this.mapa.recibirMineral(this.recolectado,this.equipo);
		this.recolectado = 0;
	}
	
	public void realizarExtraccion(){
		this.recolectado += recurso.extraer();
	}
}
