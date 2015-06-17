package fiuba.algo3.algocraft.modelo;

import java.util.Collection;

public class GestorDeUbicaciones {

	private int ancho; //x
	private int largo; //y
	private int alto; //z
	
	private Grafo<Posicion> grafo;
	private IElemento[][][] elementos;
	public GestorDeUbicaciones(int ancho, int largo, int alto) {
		this.grafo = new Grafo<Posicion>();
		this.ancho = ancho;
		this.largo = largo;
		this.alto = alto;
		this.elementos = new IElemento[this.ancho+1][this.largo+1][this.alto+1];
		
		for (int x = 1; x <= this.ancho; x++){
			for (int y = 1; y <= this.largo; y++){
				for (int z = 0; z <= this.alto; z++){
					this.nuevoNodo(new Posicion(x,y,z));
				}
			}
		}
	}
	
	public IElemento getElemento(int x, int y, int z) {
		return this.elementos[x][y][z];
	}
	public boolean estaOcupado(int x, int y, int z) {
		if (x == 0 || y == 0)
			return true;
		return elementos[x][y][z] != null;
	}
	
	public void desocuparPosicion(Posicion pos) {
		elementos[pos.x()][pos.y()][pos.z()] = null;
		this.nuevoNodo(pos);
	}
	
	public void ocuparPosicion(IElemento elemento, Posicion pos){
		this.elementos[pos.x()][pos.y()][pos.z()] = elemento;
		this.grafo.eliminarNodo(pos.toString());
	}
	
	public Collection<Posicion> getHojaDeRuta(Posicion inicial, Posicion destino) {
		return grafo.getCaminoMinimo(inicial.toString(), destino.toString());
	}
	
	private void nuevoNodo(Posicion pos){
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
		
		if (!this.estaOcupado(x,y,z)) return posAnt;
		
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

	public int getDistancia(Posicion posInicial, Posicion posFinal) {
		int difX = Math.abs(posInicial.x() - posFinal.x());
		int difY = Math.abs(posInicial.y() - posFinal.y());
		return (int) Math.round(Math.sqrt( difX*difX + difY*difY));
	}
}
