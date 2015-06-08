package fiuba.algo3.algocraft.modelo;


public class Zealot extends Unidad {

	public Zealot() {
		this.vida = 100;
	}

	@Override
	public int getNivel() {
		return 0;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
