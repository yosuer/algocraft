package fiuba.algo3.ejemplo1;

public abstract class Elemento {
	
	private Posicion posicion;
	
	public Elemento(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion obtenerPosicion() {
		return this.posicion;
	}

}
