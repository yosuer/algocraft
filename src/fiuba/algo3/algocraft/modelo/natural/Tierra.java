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

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		return (o.getClass() == this.getClass());
	}

	@Override
	public void eliminarseDelMapa(Mapa mapa) {
		// TODO Auto-generated method stub

	}

}
