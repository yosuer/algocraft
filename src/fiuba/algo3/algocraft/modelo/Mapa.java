package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorElementoNoEncontrado;

public class Mapa {

	private int ancho; //x
	private int largo; //y
	private int alto; //z
	
	private Collection<IElemento> elementosActivos;
	private Collection<Unidad> unidadesPreparadas;
	private Grafo<Posicion> grafo;
	private IElemento[][][] elementos;
	private GestorDeRecursos gestorDeRecursos;
	private float poblacionTotal;

	public Mapa() {
		this.ancho = 100;
		this.largo = 100;
		this.alto = 1;
		this.elementosActivos = new ArrayList<IElemento>();
		this.unidadesPreparadas = new ArrayList<Unidad>();
		this.grafo = new Grafo<Posicion>();
		this.gestorDeRecursos = new GestorDeRecursos();
		this.poblacionTotal = 10;
				
		elementos = new IElemento[this.ancho+1][this.largo+1][this.alto+1];
		
		for (int x = 1; x <= this.ancho; x++){
			for (int y = 1; y <= this.largo; y++){
				for (int z = 0; z <= this.alto; z++){
					this.agregarElementoEnGrafo(new Posicion(x,y,z));
				}
			}
		}
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
	
	public boolean estaOcupado(int x, int y, int z) {
		if (x == 0 || y == 0)
			return true;
		return this.getElemento(x, y, z) != null;
	}
	
	public boolean estaOcupado(Posicion p) {
		return this.estaOcupado(p.x(), p.y(), p.z());
	}
	
	public void desocuparPosicion(Posicion pos) {
		elementos[pos.x()][pos.y()][pos.z()] = null;
		this.agregarElementoEnGrafo(pos);
	}
	
	public void ubicarElemento(IElemento elemento, Posicion pos){
		this.elementos[pos.x()][pos.y()][pos.z()] = elemento;
		this.grafo.eliminarNodo(pos.toString());
	}
	
	public void agregarElemento(int x, int y, IElemento elemento) {
		
		Posicion pos = new Posicion(x,y,elemento.getNivel());
		elemento.setPosicion(pos); //elemento verifica la coord z segun su nivel
		
		try {
			elemento.agregarseEn(this);
		} catch (RuntimeException e){
			throw e;
		}
		this.elementosActivos.add(elemento);
		this.ubicarElemento(elemento, pos);
	}
	
	public void quitarElemento(IElemento elemento) {
		if (!this.estaOcupado(elemento.getPosicion()))
				throw new ErrorElementoNoEncontrado();

		this.desocuparPosicion(elemento.getPosicion());
		this.elementosActivos.remove(elemento);
	}
	
	public IElemento getElemento(int x, int y, int z) {
		return this.elementos[x][y][z];
	}
	
	public boolean existenElementos(Collection<IElemento> aBuscar){
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
		Collection<Posicion> camino =
			this.grafo.getCaminoMinimo(inicial.toString(), destino.toString());
		
		Collection<Posicion> hojaDeRuta = new ArrayList<Posicion>();
		Iterator<Posicion> it = camino.iterator();
		while (it.hasNext()){
			hojaDeRuta.add(it.next());
		}
		
		return hojaDeRuta;
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
	
	private void agregarElementoEnGrafo(Posicion pos) {
		grafo.nuevoNodo(pos);
		int x = pos.x();
		int y = pos.y();
		int z = pos.z();
		
		grafo.arista(pos.toString(), (x-1)+","+(y-1)+","+z);
		grafo.arista(pos.toString(), (x-1)+","+y+","+z);
		grafo.arista(pos.toString(), (x-1)+","+(y+1)+","+z);
		
		grafo.arista(pos.toString(),  x+","+(y-1)+","+z);
		grafo.arista(pos.toString(),  x+","+(y+1)+","+z);
		
		grafo.arista(pos.toString(), (x+1)+","+(y-1)+","+z);
		grafo.arista(pos.toString(), (x+1)+","+y+","+z);
		grafo.arista(pos.toString(), (x+1)+","+(y+1)+","+z);
	}
	
	public Posicion getPosicionProxima(Posicion posAnt){
		int x = posAnt.x();
		int y = posAnt.y();
		int z = posAnt.z();
		int n=1;
		
		if (!this.estaOcupado(posAnt)) return posAnt;
		
		while (n < 5){
			if (!this.estaOcupado(x-n, y-n, z)) return new Posicion(x-n,y-n,z); 
			if (!this.estaOcupado(x-n, y, z)) return new Posicion(x-n,y,z); 
			if (!this.estaOcupado(x-n, y+n, z)) return new Posicion(x-n,y+n,z); 
			if (!this.estaOcupado(x, y-n, z)) return new Posicion(x,y-n,z);
			if (!this.estaOcupado(x, y+n, z)) return new Posicion(x,y+n,z);
			if (!this.estaOcupado(x+n, y-n, z)) return new Posicion(x+n,y-n,z);
			if (!this.estaOcupado(x+n, y, z)) return new Posicion(x+n,y,z);
			if (!this.estaOcupado(x+n, y+n, z)) return new Posicion(x+n,y+n,z);
			n++;
		}
		
		return posAnt;
	}

	public double getPoblacionTotal() {
		return this.poblacionTotal;
	}

	public int getMineralTotal() {
		return this.gestorDeRecursos.getMineralTotal();
	}

	public int getVespenoTotal() {
		return this.gestorDeRecursos.getVespenoTotal();
	}

	public void recibirMineral(int recolectado) {
		this.gestorDeRecursos.recibirMineral(recolectado);
	}

	public void recibirVespeno(int recolectado) {
		this.gestorDeRecursos.recibirVespeno(recolectado);
	}
	
	public void gastarRecursos(int mineral, int vespeno){
		this.gestorDeRecursos.gastarRecursos(mineral,vespeno);
	}

	public void consumirPoblacion(float suministro) {
		if (this.poblacionTotal < suministro)
					throw new ErrorCapacidadDePoblacionInsuficiente();
		this.poblacionTotal -= suministro;
	}
	
	public void aumentarPoblacion(float suministro) {
		if (this.poblacionTotal < 200)
			this.poblacionTotal += suministro;
	}
	
	public void restarPoblacion(float suministro) {
		if (this.poblacionTotal > 0)
			this.poblacionTotal -= suministro;
	}
}
