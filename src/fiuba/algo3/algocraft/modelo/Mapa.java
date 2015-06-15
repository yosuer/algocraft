package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorElementoNoEncontrado;

public class Mapa {
	private int ancho; //x
	private int largo; //y
	private int alto; //z
	
	private Collection<IElemento> elementosActivos;
	private Collection<Unidad> unidadesPreparadas;
	private GestorDeRecursos gestorDeRecursos;
	private GestorDeUbicaciones gestorDeUbicaciones;
	private FloatRango poblacionTotal;
	private Equipo equipoActual;

	public Mapa() {
		this.ancho = 100;
		this.largo = 100;
		this.alto = 1;
		this.elementosActivos = new ArrayList<IElemento>();
		this.unidadesPreparadas = new ArrayList<Unidad>();
		this.gestorDeUbicaciones = new GestorDeUbicaciones(ancho,largo,alto);
		this.gestorDeRecursos = new GestorDeRecursos();
		this.poblacionTotal = new FloatRango(200);
		this.poblacionTotal.disminuir(190);
		this.equipoActual = new Equipo("equipo");
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
	
	public void agregarElemento(int x, int y, IElemento elemento) {
		
		Posicion pos = new Posicion(x,y,elemento.getNivel());
		elemento.setPosicion(pos); //elemento verifica la coord z segun su nivel
		try {
			elemento.agregarseEn(this);
		} catch (RuntimeException e){
			throw e;
		}
		this.equipoActual.agregarElemento(elemento);
		this.elementosActivos.add(elemento);
		this.ubicarElemento(elemento, pos);
	}
	
	public void quitarElemento(IElemento elemento) {
		if (!this.estaOcupado(elemento.getPosicion()))
				throw new ErrorElementoNoEncontrado();

		this.desocuparPosicion(elemento.getPosicion());
		this.elementosActivos.remove(elemento);
		this.equipoActual.removerElemento(elemento);
	}
	
	public boolean existenElementos(Collection<IElemento> aBuscar){
		this.equipoActual.existen(aBuscar);
		return this.elementosActivos.containsAll(aBuscar);
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
	}

	public Collection<Posicion> getHojaDeRuta(Posicion inicial, Posicion destino) {
		return this.gestorDeUbicaciones.getHojaDeRuta(inicial, destino);
	}
	
	public Collection<Posicion> moverElemento(IElemento e, int x, int y) {
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
		//this.equipoActual.pasarTurno();
		Iterator<IElemento> it = elementosActivos.iterator();
		while (it.hasNext()){
			it.next().pasarTurno();
		}
		
		Iterator<Unidad> it2 = this.unidadesPreparadas.iterator();
		while (it2.hasNext()){
			Unidad u = it2.next();
			this.agregarElemento(u.getPosicion().x(),u.getPosicion().y(), u);
		}
		this.unidadesPreparadas.clear();
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
		this.unidadesPreparadas.add(u);
	}
	
	public Posicion getPosicionProxima(Posicion posAnt){
		return this.gestorDeUbicaciones.getPosicionProxima(posAnt);
	}

	public double getPoblacionTotal() {
		return this.poblacionTotal.val();
	}

	public int getMineralTotal() {
		int m = this.equipoActual.getMineralTotal();
		return this.gestorDeRecursos.getMineralTotal();
	}

	public int getVespenoTotal() {
		int m = this.equipoActual.getVespenoTotal();
		return this.gestorDeRecursos.getVespenoTotal();
	}

	public void recibirMineral(int recolectado) {
		this.equipoActual.recibirMineral(recolectado);
		this.gestorDeRecursos.recibirMineral(recolectado);
	}

	public void recibirVespeno(int recolectado) {
		this.equipoActual.recibirVespeno(recolectado);
		this.gestorDeRecursos.recibirVespeno(recolectado);
	}
	
	public void gastarRecursos(int mineral, int vespeno){
		this.equipoActual.gastarRecursos(mineral,vespeno);
		this.gestorDeRecursos.gastarRecursos(mineral,vespeno);
	}

	public void consumirPoblacion(float suministro) {
		if (this.poblacionTotal.val() < suministro)
					throw new ErrorCapacidadDePoblacionInsuficiente();
		this.poblacionTotal.disminuir(suministro);
		//this.equipoActual.consumirPoblacion(suministro);
	}
	
	public void aumentarPoblacion(float suministro) {
		this.equipoActual.aumentarPoblacion(suministro);
		this.poblacionTotal.aumentar(suministro);
	}
	
	public void restarPoblacion(float suministro) {
		this.equipoActual.restarPoblacion(suministro);
		this.poblacionTotal.disminuir(suministro);
	}


}
