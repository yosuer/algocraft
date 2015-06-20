package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.excepciones.ErrorNoExisteRecursoEnLaPosicion;
import fiuba.algo3.algocraft.modelo.natural.Mineral;

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
		} catch (NullPointerException e) {
			throw new ErrorNoExisteRecursoEnLaPosicion();
		} catch (ClassCastException e){
			throw new ErrorExtractorDeRecursosIncompatible();
		}
		mapa.agregarControlable(this);
		this.mapa = mapa;
	}
	
	public void ejecutarAcciones(){
		this.realizarExtraccion();
		this.depositarRecolectado(this.equipo);
	}
	
	public void depositarRecolectado(Equipo equipo) {
		this.mapa.recibirMineral(this.recolectado,this.equipo);
		this.recolectado = 0;
	}
	
	public void realizarExtraccion(){
		this.recolectado += recurso.extraer();
	}
}
