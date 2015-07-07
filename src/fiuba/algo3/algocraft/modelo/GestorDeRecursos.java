package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;

public class GestorDeRecursos {

	private int mineralTotal;
	private int vespenoTotal;

	public GestorDeRecursos() {
		this.mineralTotal = 200;
		this.vespenoTotal = 0;
	}

	public int getMineralTotal() {
		return this.mineralTotal;
	}

	public int getVespenoTotal() {
		return this.vespenoTotal;
	}

	public void recibirMineral(int recolectado) {
		this.mineralTotal += recolectado;
	}

	public void recibirVespeno(int recolectado) {
		this.vespenoTotal += recolectado;
	}

	public void gastarRecursos(int mineral, int vespeno) {
		if ((mineralTotal < mineral) | (vespenoTotal < vespeno))
			throw new ErrorRecursosInsuficientes();
		else {
			this.mineralTotal -= mineral;
			this.vespenoTotal -= vespeno;
		}
	}
}
