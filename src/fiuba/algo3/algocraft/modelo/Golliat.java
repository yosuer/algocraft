package fiuba.algo3.algocraft.modelo;

public class Golliat extends Unidad {

	public Golliat() {
		this.tiempoDeConstruccion = 6;
		this.vida = 125;
		this.costoMineral = 100;
		this.costoVespeno = 50;
		this.nivel = 0;
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
