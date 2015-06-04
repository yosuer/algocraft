package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.Posicion;

public abstract class Edificio extends Elemento{

	protected Jugador jugador;
	
	public Edificio(Posicion posicion) {
		super(posicion);
	}
	
	public void setJugador(Jugador dueño){
		jugador = dueño;
	}
	
	public int getCostoMineral() {
		return 0;
	}
	
	public int getCostoVespeno() {
		return 0;
	}

	public boolean validarCostos() {
		return false;
	}

	public void cobrarCostos() {
	}

}
