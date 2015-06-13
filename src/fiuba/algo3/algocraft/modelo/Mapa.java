package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;

public class Mapa {

	private int ancho; //x
	private int largo; //y
	private int alto; //z
	
	private Collection<IElemento> elementosActivos;
	private Collection<Unidad> unidadesPreparadas;
	private Grafo<Posicion> grafo;
	private IElemento[][][] elementos;
	private GestorDeRecursos gestorDeRecursos;

	public Mapa() {
		this.ancho = 100;
		this.largo = 100;
		this.alto = 1;
		this.elementosActivos = new ArrayList<IElemento>();
		this.unidadesPreparadas = new ArrayList<Unidad>();
		this.grafo = new Grafo<Posicion>();
		this.gestorDeRecursos = new GestorDeRecursos();
				
		elementos = new IElemento[this.ancho+1][this.largo+1][this.alto+1];
		
		for (int x = 1; x <= this.ancho; x++){
			for (int y = 1; y <= this.largo; y++){
				for (int z = 0; z <= this.alto; z++){
					elementos[x][y][z] = null;
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
		return elementos[x][y][z] != null;
	}
	
	public void agregarElemento(int x, int y, IElemento elemento) {
		
		Posicion pos = new Posicion(x,y,elemento.getNivel());
		elemento.setPosicion(pos); //elemento verifica la coord z segun su nivel
		
		try {
			elemento.agregarseEn(this);
		} catch (ErrorAgregandoElementoAlMapa e){
			throw e;
		}
		
		this.elementosActivos.add(elemento);
		this.elementos[pos.x()][pos.y()][pos.z()] = elemento;
		
		this.grafo.eliminarNodo(pos.toString());
	}
	

	public void quitarElemento(IElemento elemento) {
		Posicion pos = elemento.getPosicion();
		elementos[pos.x()][pos.y()][pos.z()] = null;
		this.agregarElementoEnGrafo(elemento.getPosicion());
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
				this.elementos[posAnt.x()][posAnt.y()][posAnt.z()] = null;
				this.quitarElemento(e);
				this.grafo.eliminarNodo(posNueva.toString());
				this.elementos[posNueva.x()][posNueva.y()][posNueva.z()] = e;
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

	public int getPoblacionTotal() {
		int poblacion = 0;
		Iterator<IElemento> it = elementosActivos.iterator();
		while (it.hasNext()){
			poblacion += it.next().getPoblacion();
		}
		return poblacion;
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
}
