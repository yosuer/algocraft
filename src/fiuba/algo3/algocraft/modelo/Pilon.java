package fiuba.algo3.algocraft.modelo;

public class Pilon extends EdificioCasa {

	public Pilon() {
		this.vida = 600;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 5;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
