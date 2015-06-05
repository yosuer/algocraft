package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;

public class Casillero {

	private Elemento elemento;
	private int[] niveles;
	
	public Casillero(){
		this.elemento = null;
		this.niveles = new int[2];
	}
	
	public void agregar(Elemento elemento) {
		this.elemento = elemento;
	}

	public Elemento obtenerElemento() {
		return this.elemento;
	}
	
	public boolean hayElemento() {
		return this.elemento != null;
	}
	
	public boolean disponibleEnNivel(int capa){
		return true;
	}

}
