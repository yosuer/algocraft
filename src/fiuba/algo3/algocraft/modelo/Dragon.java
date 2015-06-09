package fiuba.algo3.algocraft.modelo;

public class Dragon extends Unidad {

	public Dragon(){
		this.vida = 150;
	}
	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
