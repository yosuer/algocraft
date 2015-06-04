package fiuba.algo3.algocraft.modelo;


public abstract class Elemento {
	
	protected Posicion posicion;
	
	public Elemento(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public void adherirEn(Elemento otroElemento) {
	}
}
