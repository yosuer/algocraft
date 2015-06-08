package fiuba.algo3.algocraft.modelo;


public class Criadero extends BasePrincipal {

	public Criadero(Mapa mapa) {
		super(mapa);
		this.vida = 1500;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
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
