package fiuba.algo3.algocraft.modelo;


public abstract class Edificio extends Elemento{

	Jugador jug;
	
	public Edificio(Posicion posicion) {
		super(posicion);
	}
	
	public void setJugador(Jugador jug){
		this.jug = jug;
	}
	
	public int getCostoMineral() {
		return 0;
	}
	
	public int getCostoVespeno() {
		return 0;
	}

	public boolean validarCostos(Jugador jugador){
		return jugador.mineral() >= this.getCostoMineral() & 
				jugador.vespeno() >= this.getCostoVespeno();
	}

	public void cobrarCostos(Jugador jugador) {
		jugador.cobrar(this.getCostoMineral(),this.getCostoVespeno());
	}

}
