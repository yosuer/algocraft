package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;

public class Casillero {

	private Elemento[] niveles;
	
	public Casillero(){
		this.niveles = new Elemento[1];
	}
	
	public void agregar(Elemento elemento) {
		if (!this.hayElemento(elemento.getNivel())) 
					niveles[elemento.getNivel()] = elemento;
	}

	public Elemento obtenerElemento(int nivel) {
		return niveles[nivel];
	}
	
	public boolean hayElemento(int nivel) {
		return niveles[nivel] != null;
	}
	
	public boolean disponibleEnNivel(int capa){
		return true;
	}

}
