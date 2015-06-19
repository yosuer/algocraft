package fiuba.algo3.algocraft.modelo;

public class Tierra extends Estatico {

	public Tierra(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Tierra() {
	}

	public boolean equals(Object o) {
		if(this == o) return true;
		if (o == null) return false;
		
		return (o.getClass() == this.getClass());
	}

	@Override
	public void eliminarseDelMapa(Mapa mapa) {
		// TODO Auto-generated method stub
		
	}


}
