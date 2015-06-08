package fiuba.algo3.algocraft.modelo;


public class CentroDeMando extends BasePrincipal {

	public CentroDeMando(Mapa mapa) {
		super(mapa);
		this.vida = 1500;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 7;
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
