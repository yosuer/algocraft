package fiuba.algo3.algocraft.modelo;

public class Casillero {

	private Elemento elemento; 
	
	public Casillero(){
		this.elemento = null;
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

}
