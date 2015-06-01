package fiuba.algo3.algocraft;

public class Mapa {

	private int ancho;
	private int alto;

	private Casillero[][] casillero;

	public Mapa() {
		this.ancho = 100;
		this.alto = 100;
		
		casillero = new Casillero[this.ancho][this.alto];
		
		for (int x = 0; x < this.ancho; x++){
			for (int y = 0; y < this.alto; y++){
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
		
		if ( !this.casillero[elemento.obtenerPosicion().posX()][elemento.obtenerPosicion().posY()].hayElemento() )
			this.casillero[elemento.obtenerPosicion().posX()][elemento.obtenerPosicion().posY()].agregar(elemento);
	}

	public Elemento elemento(Posicion pos) {
		return this.casillero[pos.posX()][pos.posY()].obtenerElemento();
	}

}
