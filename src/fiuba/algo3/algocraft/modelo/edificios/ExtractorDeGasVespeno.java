package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.Recurso;
import fiuba.algo3.algocraft.Vespeno;
import fiuba.algo3.algocraft.modelo.Posicion;

public abstract class ExtractorDeGasVespeno extends Edificio implements ExtractorDeRecursos{

	protected Vespeno recurso;
	protected int recolectado;
	
	public ExtractorDeGasVespeno(Posicion posicion) {
		super(posicion);
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
}
