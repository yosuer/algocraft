package fiuba.algo3.algocraft.modelo;

public class DepositoDeSuministros extends Edificio 
									implements ElementoPoblacion {

	public DepositoDeSuministros() {
		this.vida = 500;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 6;
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
