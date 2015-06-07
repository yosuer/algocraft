package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;


public class Mapa {

	private int ancho; //x
	private int largo; //y
	private int alto; //z
	

	private IElemento[][][] elementos;

	public Mapa() {
		this.ancho = 100;
		this.largo = 100;
		this.alto = 2;
		
		elementos = new IElemento[this.ancho+1][this.largo+1][this.alto+1];
		
		for (int x = 1; x <= this.ancho; x++){
			for (int y = 1; y <= this.largo; y++){
				for (int z = 1; z <= this.alto; z++){
					elementos[x][y][z] = null;
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
		if (!estaOcupado(pos.x(),pos.y(),pos.z()))
			elementos[pos.x()][pos.y()][pos.z()] = elemento;
	}
	
	public IElemento getElemento(int x, int y, int z) {
		return this.elementos[x][y][z];
	}
	
	public void inicializarMapa() {
		//Jugador1
		this.agregarElemento(2,2,new Mineral(this));
		this.agregarElemento(2,3,new Mineral(this));
		this.agregarElemento(2,4,new Mineral(this));
		this.agregarElemento(2,5,new Mineral(this));
		this.agregarElemento(2,6,new Mineral(this));
		this.agregarElemento(3,2,new Mineral(this));
		this.agregarElemento(4,2,new Mineral(this));
		this.agregarElemento(5,2,new Mineral(this));
		this.agregarElemento(6,2,new Mineral(this));
		
		this.agregarElemento(4,6,new Vespeno(this));
		
		//Jugador2
		this.agregarElemento(99,99,new Mineral(this));
		this.agregarElemento(98,99,new Mineral(this));
		this.agregarElemento(97,99,new Mineral(this));
		this.agregarElemento(96,99,new Mineral(this));
		this.agregarElemento(95,99,new Mineral(this));
		this.agregarElemento(99,98,new Mineral(this));
		this.agregarElemento(99,97,new Mineral(this));
		this.agregarElemento(99,96,new Mineral(this));
		this.agregarElemento(99,95,new Mineral(this));

		this.agregarElemento(95,97,new Vespeno(this));

	}

	public void moverElemento(IElemento elemento, int x, int y) {

		Posicion posAnt = elemento.getPosicion();
		
		if (elemento.moverseA( new Posicion(x,y,elemento.getNivel())) ) 
			elementos[posAnt.x()][posAnt.y()][posAnt.z()] = null;
	}

}
