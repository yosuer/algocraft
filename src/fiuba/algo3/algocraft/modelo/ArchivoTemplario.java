package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class ArchivoTemplario extends EdificioUnidadesAvanzadas {

	public ArchivoTemplario() {
		super();
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 200;
		this.tiempoDeConstruccion = 9;
		this.nivel= 0;
		this.unidadesEnProduccion = new ListaMU<Unidad>();
	}

	public void crearAltoTemplario() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new AltoTemplario());
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
