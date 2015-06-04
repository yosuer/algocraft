package fiuba.algo3.algocraft;

import java.util.ArrayList;

public class Juego {
	
	static Juego instance = null;
	private ArrayList<Jugador> jugadores;
	private Mapa campoDeBatalla;

	private Juego()
	{
		jugadores = new ArrayList<Jugador>();
		campoDeBatalla = new Mapa();
	}	
	
	static public Juego getInstance() {
		if(instance == null) {
	         instance = new Juego();
	      }
	     return instance;
	}
	
	public static void resetInstance() {
		instance = null;
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


	public void iniciarJuego() {
		campoDeBatalla.inicializarMapa();
		
		Jugador j1 = jugadores.get(0);
		Jugador j2 = jugadores.get(1);
		Elemento e1 = j1.crearBasePrincipal(new Posicion(97,97));
		Elemento e2 = j2.crearBasePrincipal(new Posicion(4,4));
		campoDeBatalla.agregar(e1);
		campoDeBatalla.agregar(e2);
		
	}

	public void agregarElementoAlMapa(Elemento elemento) {
		Posicion pos = elemento.getPosicion();
		Elemento e = campoDeBatalla.getElemento(pos) ;
		if (e == null) campoDeBatalla.agregar(e);
		else e.adherirEn(elemento);
	}
}
