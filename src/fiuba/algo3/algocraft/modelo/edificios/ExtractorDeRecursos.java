package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.Recurso;
import fiuba.algo3.algocraft.modelo.Posicion;

public interface ExtractorDeRecursos {

	Posicion getPosicion();
	
	public void asignarRecurso(Recurso recurso);

}
