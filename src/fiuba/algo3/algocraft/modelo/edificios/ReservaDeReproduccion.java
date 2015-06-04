package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.unidades.Zerling;

public class ReservaDeReproduccion extends EdificioUnidadesBasicas {

	public ReservaDeReproduccion(Posicion posicion) {
		super(posicion);
	}

	@Override
	public Elemento crearElemento() {
		Posicion posElementoCreado = new Posicion(posicion.posX()+1,posicion.posY()+1);
		return new Zerling(posElementoCreado);
	}

}
