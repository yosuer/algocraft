package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;


public class ReservaDeReproduccion extends EdificioUnidadesBasicas {

	public ReservaDeReproduccion() {
		super();
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 10;
		this.nivel = 0;
		this.unidadesEnProduccion = new ListaMU<Unidad>();
	}

	public void crearZerling() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Marine());
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
