package fiuba.algo3.algocraft.modelo;

public class Pilon extends Edificio implements ElementoPoblacion {

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

	@Override
	public int getPoblacion() {
		return 10;
	}

}
