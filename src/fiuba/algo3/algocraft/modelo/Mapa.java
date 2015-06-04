package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.Mineral;
import fiuba.algo3.algocraft.Vespeno;

public class Mapa {

	private int ancho;
	private int alto;

	private Casillero[][] casillero;

	public Mapa() {
		this.ancho = 100;
		this.alto = 100;
		
		casillero = new Casillero[this.ancho+1][this.alto+1];
		
		for (int x = 1; x <= this.ancho; x++){
			for (int y = 1; y <= this.alto; y++){
				casillero[x][y] = new Casillero();
			}
		}
	}

	public int ancho() {
		return this.ancho;
	}

	public int alto() {
		return this.alto;
	}

	public void agregar(Elemento elemento) {
		
		if ( !this.casillero[elemento.getPosicion().posX()][elemento.getPosicion().posY()].hayElemento() )
			this.casillero[elemento.getPosicion().posX()][elemento.getPosicion().posY()].agregar(elemento);
	}

	public Elemento getElemento(Posicion pos) {
		return this.casillero[pos.posX()][pos.posY()].obtenerElemento();
	}
	
	public void inicializarMapa() {
		//Jugador1
		this.agregar(new Mineral(new Posicion (2,2)));
		this.agregar(new Mineral(new Posicion (2,3)));
		this.agregar(new Mineral(new Posicion (2,4)));
		this.agregar(new Mineral(new Posicion (2,5)));
		this.agregar(new Mineral(new Posicion (2,6)));
		this.agregar(new Mineral(new Posicion (3,2)));
		this.agregar(new Mineral(new Posicion (4,2)));
		this.agregar(new Mineral(new Posicion (5,2)));
		this.agregar(new Mineral(new Posicion (6,2)));
		
		this.agregar(new Vespeno(new Posicion(4,6)));
		
		//this.agregar(new CentroDeMando());
		
		//Jugador2
		this.agregar(new Mineral(new Posicion (99,99)));
		this.agregar(new Mineral(new Posicion (98,99)));
		this.agregar(new Mineral(new Posicion (97,99)));
		this.agregar(new Mineral(new Posicion (96,99)));
		this.agregar(new Mineral(new Posicion (95,99)));
		this.agregar(new Mineral(new Posicion (99,98)));
		this.agregar(new Mineral(new Posicion (99,97)));
		this.agregar(new Mineral(new Posicion (99,96)));
		this.agregar(new Mineral(new Posicion (99,95)));

		this.agregar(new Vespeno(new Posicion(95,97)));

	}

}