package fiuba.algo3.algocraft;

import java.util.ArrayList;
import java.util.Collection;

public class Juego {
	
	private Collection<Jugador> jugadores;
	private Mapa campoDeBatalla;

	public Juego()
	{
		jugadores = new ArrayList<Jugador>();
	}	
	
	
	public int cantidadDeJugadores() {
		return jugadores.size();
	}

	
	public void agregarJugador(Jugador jugador) {
		if(! jugadores.contains(jugador)) jugadores.add(jugador);
	}


	public void agregarMapa(Mapa mapa) {
		this.campoDeBatalla = mapa;
	}

}
