package fiuba.algo3.algocraft.modelo;


public class Zealot extends Unidad {

	public Zealot() {
		this.vida = 160;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
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
