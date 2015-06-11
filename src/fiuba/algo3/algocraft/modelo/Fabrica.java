package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class Fabrica extends EdificioUnidadesAvanzadas {

	public Fabrica() {
		super();
		this.vida = 1250;
		this.costoMineral = 200;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 12;
		this.edificiosRequeridos.add(new Barraca());
		this.unidadesEnProduccion = new ListaMU<Unidad>();
	}
	
	public void crearGolliat() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Golliat());
	}
	
	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

}
