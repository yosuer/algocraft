package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.Jugador;
import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.Posicion;

public abstract class Edificio extends Elemento{

	Jugador due�o;
	
	public Edificio(Posicion posicion) {
		super(posicion);
	}
	
	public void setJugador(Jugador due�o){
		this.due�o = due�o;
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
