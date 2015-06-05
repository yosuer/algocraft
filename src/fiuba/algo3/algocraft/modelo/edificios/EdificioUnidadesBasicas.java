package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.CreadorDeUnidades;
import fiuba.algo3.algocraft.modelo.Posicion;

public abstract class EdificioUnidadesBasicas extends Elemento implements CreadorDeUnidades{

	public EdificioUnidadesBasicas(Posicion posicion) {
		super(posicion);
	}

}
