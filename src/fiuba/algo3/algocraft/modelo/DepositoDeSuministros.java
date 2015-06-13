package fiuba.algo3.algocraft.modelo;

public class DepositoDeSuministros extends Edificio {

	public DepositoDeSuministros() {
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.estadoFisico = new Terran(500);
		this.estado = new Construyendose(this, 6);
	}

	@Override
	public int vidaActual() {
		return this.estadoFisico.getVida();
	}

	@Override
	public int getPoblacion() {
		return this.estado.getPoblacion();
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
	}

}
