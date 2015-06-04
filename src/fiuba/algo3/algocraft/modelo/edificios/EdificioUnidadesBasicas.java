package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.ElementoCreador;
import fiuba.algo3.algocraft.modelo.Posicion;

public abstract class EdificioUnidadesBasicas extends Elemento implements ElementoCreador{

	public EdificioUnidadesBasicas(Posicion posicion) {
		super(posicion);
	}

}
