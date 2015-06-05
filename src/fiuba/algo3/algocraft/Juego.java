package fiuba.algo3.algocraft;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.ErrorCantidadDeJugadoresInvalida;
import fiuba.algo3.algocraft.modelo.Elemento;
import fiuba.algo3.algocraft.modelo.Mapa;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.Edificio;

public class Juego {
	
	static Juego instance = null;
	private ArrayList<Jugador> jugadores;
	private Mapa campoDeBatalla;
	private Jugador jugadorActual;

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


	public void asignarMapa(Mapa mapa) {
		this.campoDeBatalla = mapa;
	}


	public void iniciarJuego() {
		campoDeBatalla.inicializarMapa();

		try{
			campoDeBatalla.agregar(jugadores.get(0).crearBasePrincipal(new Posicion(97,97)));
			campoDeBatalla.agregar(jugadores.get(1).crearBasePrincipal(new Posicion(4,4)));
		} catch (NullPointerException e){
			throw new ErrorCantidadDeJugadoresInvalida();
		}
		jugadorActual = jugadores.get(0);
	}

	public void agregarEdificioAlMapa(Edificio edificio) {
		if (edificio.validarCostos(jugadorActual)) {
			Elemento elementoEnPosicion = campoDeBatalla.getElemento(edificio.getPosicion()) ;
			try{
				if (elementoEnPosicion == null) campoDeBatalla.agregar(edificio);
				else elementoEnPosicion.adherirEn(edificio);
				edificio.cobrarCostos(jugadorActual);
			} catch(RuntimeException e) {
			}
		}
	}
	
	public void siguienteTurno(){
		//posible lista circular en caso de q mas de 2 jugadores
		if (jugadorActual == jugadores.get(0)) jugadorActual = jugadores.get(1);
		else jugadorActual = jugadores.get(0);
	}

	public Jugador getJugadorActual() {
		return this.jugadorActual;
	}
}
