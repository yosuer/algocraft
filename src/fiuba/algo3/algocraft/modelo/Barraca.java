package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class Barraca extends EdificioUnidadesBasicas {

	public Barraca() {
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 12;
	}
	
	@Override
	public Unidad crearUnidad() {
		if (this.tiempoDeConstruccion > 0)
			throw new ErrorEdificioEnConstruccion();
		
		return new Marine();
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
