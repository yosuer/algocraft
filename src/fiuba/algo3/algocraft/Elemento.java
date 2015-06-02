package fiuba.algo3.algocraft;

public abstract class Elemento {
	
	private Posicion posicion;
	
	public Elemento(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}

}
