package fiuba.algo3.algocraft.modelo;


public class Mapa {

	private int ancho;
	private int alto;

	private Casillero[][] casilleros;

	public Mapa() {
		this.ancho = 100;
		this.alto = 100;
		
		casilleros = new Casillero[this.ancho+1][this.alto+1];
		
		for (int x = 1; x <= this.ancho; x++){
			for (int y = 1; y <= this.alto; y++){
				casilleros[x][y] = new Casillero();
			}
		}
	}

	public int ancho() {
		return this.ancho;
	}

	public int alto() {
		return this.alto;
	}

	public void agregar(Elemento elemento, int nivel) {
		
		if ( !this.casilleros[elemento.getPosicion().posX()][elemento.getPosicion().posY()].hayElemento(nivel) )
			this.casilleros[elemento.getPosicion().posX()][elemento.getPosicion().posY()].agregar(elemento);
	}

	public Elemento getElemento(Posicion pos, int nivel) {
		return this.casilleros[pos.posX()][pos.posY()].obtenerElemento(nivel);
	}
	
	public void inicializarMapa() {
		//Jugador1
		this.agregar(new Mineral(new Posicion (2,2)), 0);
		this.agregar(new Mineral(new Posicion (2,3)), 0);
		this.agregar(new Mineral(new Posicion (2,4)), 0);
		this.agregar(new Mineral(new Posicion (2,5)), 0);
		this.agregar(new Mineral(new Posicion (2,6)), 0);
		this.agregar(new Mineral(new Posicion (3,2)), 0);
		this.agregar(new Mineral(new Posicion (4,2)), 0);
		this.agregar(new Mineral(new Posicion (5,2)), 0);
		this.agregar(new Mineral(new Posicion (6,2)), 0);
		
		this.agregar(new Vespeno(new Posicion(4,6)), 0);
		
		//Jugador2
		this.agregar(new Mineral(new Posicion (99,99)), 0);
		this.agregar(new Mineral(new Posicion (98,99)), 0);
		this.agregar(new Mineral(new Posicion (97,99)), 0);
		this.agregar(new Mineral(new Posicion (96,99)), 0);
		this.agregar(new Mineral(new Posicion (95,99)), 0);
		this.agregar(new Mineral(new Posicion (99,98)), 0);
		this.agregar(new Mineral(new Posicion (99,97)), 0);
		this.agregar(new Mineral(new Posicion (99,96)), 0);
		this.agregar(new Mineral(new Posicion (99,95)), 0);

		this.agregar(new Vespeno(new Posicion(95,97)), 0);

	}

}
