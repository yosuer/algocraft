package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.unidades.Marine;

public class Barraca extends EdificioUnidadesBasicas {

	public Barraca(Posicion posicion) {
		super(posicion);
	}

	@Override
	public Elemento crearElemento() {
		Posicion posElementoCreado = new Posicion(posicion.posX()+1,posicion.posY()+1);
		return new Marine(posElementoCreado);
	}

}
