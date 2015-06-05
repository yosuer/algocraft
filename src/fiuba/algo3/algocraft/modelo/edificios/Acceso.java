package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.Unidad;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.unidades.Zealot;

public class Acceso extends EdificioUnidadesBasicas {

	public Acceso(Posicion posicion) {
		super(posicion);
	}
	
	@Override
	public Unidad crearUnidad() {
		Posicion posElementoCreado = new Posicion(posicion.posX()+1,posicion.posY()+1);
		return new Zealot(posElementoCreado);
	}

}
