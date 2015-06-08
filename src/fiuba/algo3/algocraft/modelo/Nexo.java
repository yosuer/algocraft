package fiuba.algo3.algocraft.modelo;


public class Nexo extends BasePrincipal {

	public Nexo(Mapa mapa) {
		super(mapa);
		this.vida = 1500;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 9;
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		// TODO Auto-generated method stub
		return this.vida;
	}

}
