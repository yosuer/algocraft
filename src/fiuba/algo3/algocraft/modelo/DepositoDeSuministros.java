package fiuba.algo3.algocraft.modelo;

public class DepositoDeSuministros extends Edificio 
									implements ElementoPoblacion {

	public DepositoDeSuministros() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 6;
		this.estadoFisico = new Terran(500);
	}

	@Override
	public int vidaActual() {
		return this.estadoFisico.getVida();
	}

	@Override
	public int getPoblacion() {
		return 10;
	}

}
