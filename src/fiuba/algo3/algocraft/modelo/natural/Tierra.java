package fiuba.algo3.algocraft.modelo.natural;

import fiuba.algo3.algocraft.modelo.Estatico;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;

public class Tierra extends Estatico {

	public Tierra(Posicion posicion) {
		this.posicion = posicion;
		this.nombre = "Tierra";
	}

	public Tierra() {
		this.nombre = "Tierra";
	}

	@Override
	public void eliminarseDelMapa(Mapa mapa) {
		// TODO Auto-generated method stub

	}

}
