package fiuba.algo3.algocraft.modelo;

public class NaveTransporteTerran extends Unidad{

	public NaveTransporteTerran() {
		this.vida = 150;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 7;
		this.nivel = 1;
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
