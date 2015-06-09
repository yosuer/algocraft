package fiuba.algo3.algocraft.modelo;

public class Espectro extends Unidad {

	public Espectro() {
		this.tiempoDeConstruccion = 8;
		this.vida = 120;
		this.costoMineral = 150;
		this.costoVespeno = 100;
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
