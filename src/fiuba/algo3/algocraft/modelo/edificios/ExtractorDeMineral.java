package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.Mineral;
import fiuba.algo3.algocraft.Recurso;
import fiuba.algo3.algocraft.modelo.Posicion;

public abstract class ExtractorDeMineral extends Edificio implements ExtractorDeRecursos{

	protected Mineral recurso;
	protected int recolectado;
	protected int costoMineral;
	protected int costoVespeno;
	
	public ExtractorDeMineral(Posicion posicion) {
		super(posicion);
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
	
}
