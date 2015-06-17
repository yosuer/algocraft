package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import fiuba.algo3.algocraft.excepciones.ErrorElementoNoEncontrado;

public class Mapa {
	private int ancho; //x
	private int largo; //y
	private int alto; //z
	
	private Collection<Estatico> elementosEstaticos;
	private GestorDeUbicaciones gestorDeUbicaciones;
	
	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo equipoActual;
	private Equipo equipoSiguiente;

	public Mapa() {
		this.ancho = 100;
		this.largo = 100;
		this.alto = 1;
		this.elementosEstaticos = new ArrayList<Estatico>();
		this.gestorDeUbicaciones = new GestorDeUbicaciones(ancho,largo,alto);
		this.equipo1 = new Equipo("EquipoRocket");
		this.equipo2 = new Equipo("EquipoNoSe");
		this.equipo1.setMapa(this);
		this.equipo2.setMapa(this);
		this.inicializarMapa();
	}

	public int ancho() {
		return this.ancho;
	}
	
	public int largo() {
		return this.largo;
	}

	public int alto() {
		return this.alto;
	}
	
	public void agregarEquipo(Equipo equipo) {
		this.equipoActual = equipo;
	}
	
	public IElemento getElemento(int x, int y, int z) {
		return this.gestorDeUbicaciones.getElemento(x,y,z);
	}
	
	public boolean estaOcupado(int x, int y, int z) {
		return this.gestorDeUbicaciones.estaOcupado(x, y, z);
	}
	public boolean estaOcupado(Posicion p) {
		return this.estaOcupado(p.x(), p.y(), p.z());
	}
	
	public void desocuparPosicion(Posicion pos) {
		this.gestorDeUbicaciones.desocuparPosicion(pos);
	}
	
	public void ubicarElemento(IElemento elemento, Posicion pos){
		this.gestorDeUbicaciones.ocuparPosicion(elemento,pos);
	}
	
	public void inicializarMapa() {
		//Jugador1
		for (int x=3; x<=6; x++) this.agregarElemento(x, 2, new Mineral());	
		for (int y=2; y<=6; y++) this.agregarElemento(2, y, new Mineral());
		this.agregarElemento(4,6,new Vespeno());
		
		//Jugador2
		for (int x=95; x<=99; x++) this.agregarElemento(x, 99, new Mineral());
		for (int y=95; y<=98; y++) this.agregarElemento(99, y, new Mineral());
		this.agregarElemento(95,97,new Vespeno());
		
		this.equipoActual = equipo1;
		this.equipoSiguiente = equipo2;
	}
	
	public void agregarElemento(int x, int y, IElemento elemento) {
		Posicion pos = new Posicion(x,y,elemento.getNivel());
		elemento.setPosicion(pos); //elemento verifica la coord z segun su nivel
		try {
			elemento.agregarseEn(this);
		} catch (RuntimeException e){
			throw e;
		}
	}
	
	public void agregarControlable(Controlable elemento) {
		this.equipoActual.agregarElemento(elemento);
		this.ubicarElemento(elemento, elemento.getPosicion());
	}
	
	public void agregarEstatico(Estatico elemento) {
		this.elementosEstaticos.add(elemento);
		this.ubicarElemento(elemento, elemento.getPosicion());
	}
	
	public void quitarElemento(IElemento elemento) {
		if (!this.estaOcupado(elemento.getPosicion()))
				throw new ErrorElementoNoEncontrado();
		this.desocuparPosicion(elemento.getPosicion());
		this.equipoActual.removerElemento(elemento);
	}
	
	public boolean existenElementos(Collection<Controlable> aBuscar){
		return this.equipoActual.existen(aBuscar);
	}

	public Collection<Posicion> getHojaDeRuta(Posicion inicial, Posicion destino) {
		return this.gestorDeUbicaciones.getHojaDeRuta(inicial, destino);
	}
	
	public Collection<Posicion> moverElemento(Controlable e, int x, int y) {
		Collection<Posicion> hojaDeRuta = null;
		if (!this.estaOcupado(x, y, e.getNivel())) {
			Collection<Posicion> camino = 
					getHojaDeRuta(e.getPosicion(),new Posicion(x,y,e.getNivel()));
			
			Iterator<Posicion> it = camino.iterator();
			Posicion posAnt = it.next();
			while (it.hasNext()){
				Posicion posNueva = it.next(); 
				e.moverseA(posNueva);
				this.desocuparPosicion(posAnt);
				this.ubicarElemento(e, posNueva);
				posAnt = posNueva;
			}
			hojaDeRuta = camino;
		}
		return hojaDeRuta;
	}
	
	public void pasarTurnoMapa(){
		this.equipoActual.pasarTurno();
		this.equipoSiguiente.pasarTurno();
		
		Equipo equipoAux;
		equipoAux = this.equipoActual;
		this.equipoActual = this.equipoSiguiente;
		this.equipoSiguiente = equipoAux;
		
		//////////////////////////////////
//		System.out.println("Poblacion: " + getPoblacionTotal());
//		System.out.println("Mineral: " + gestorDeRecursos.getMineralTotal());
//		System.out.println("Vespeno: " + gestorDeRecursos.getVespenoTotal());
//		Iterator<IElemento> i = elementosActivos.iterator();
//		while (i.hasNext()) {
//			System.out.print(i.next().getClass().getSimpleName() + " / ");
//		} System.out.println();
	}
	
	public void encolarUnidad(Unidad u){
		this.equipoActual.encolarUnidad(u);
	}
	
	public Posicion getPosicionProxima(Posicion posAnt){
		return this.gestorDeUbicaciones.getPosicionProxima(posAnt);
	}

	public double getPoblacionTotal() {
		return this.equipo1.getPoblacionTotal() + this.equipo2.getPoblacionTotal();
	}

	public int getMineralTotal() {
		return this.equipoActual.getMineralTotal();
	}

	public int getVespenoTotal() {
		return this.equipo1.getVespenoTotal()+this.equipo2.getVespenoTotal();
	}

	public void recibirMineral(int recolectado, Equipo equipo) {
		equipo.recibirMineral(recolectado);
	}
	
	public void recibirMineral(int recolectado) {
		equipo1.recibirMineral(recolectado);
		equipo2.recibirMineral(recolectado);
	}
	
	public void recibirVespeno(int recolectado) {
		equipo1.recibirVespeno(recolectado);
		equipo2.recibirVespeno(recolectado);
	}
	
	public void recibirVespeno(int recolectado, Equipo equipo) {
		equipo.recibirVespeno(recolectado);
	}
	
	public void gastarRecursos(int mineral, int vespeno){
		this.equipoActual.gastarRecursos(mineral,vespeno);
	}

	public void consumirPoblacion(float suministro) {
		this.equipoActual.consumirPoblacion(suministro);
	}
	
	public void aumentarPoblacion(float suministro, Equipo equipo) {
		equipo.aumentarPoblacion(suministro);
	}
	
	public void aumentarPoblacion(float suministro) {
		equipo1.aumentarPoblacion(suministro);
		equipo2.aumentarPoblacion(suministro);
	}
	
	public void restarPoblacion(float suministro, Equipo equipo) {
		equipo.restarPoblacion(suministro);
	}

	public int getDistancia(Posicion posInicial, Posicion posObjetivo) {
		return this.gestorDeUbicaciones.getDistancia(posInicial,posObjetivo);
	}


}
