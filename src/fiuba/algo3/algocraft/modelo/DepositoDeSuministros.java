package fiuba.algo3.algocraft.modelo;

public class DepositoDeSuministros extends EdificioCasa {

	public DepositoDeSuministros(Mapa mapa) {
		super(mapa);
		this.vida = 500;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 6;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
