package fiuba.algo3.algocraft.modelo.edificios;

import fiuba.algo3.algocraft.modelo.Posicion;

public class CentroDeMineral extends ExtractorDeMineral {

	public CentroDeMineral(Posicion posicion) {
		super(posicion);
		this.recolectado = 0;
		this.costoMineral = 50;
		this.costoVespeno = 0;
	}
	
	public boolean validarCostos() {
		return jugador.mineral() >= costoMineral & 
				jugador.vespeno() >= costoVespeno;
	}
	
	public void cobrarCostos() {
		jugador.cobrar(this.costoMineral,this.costoVespeno);
	}

}