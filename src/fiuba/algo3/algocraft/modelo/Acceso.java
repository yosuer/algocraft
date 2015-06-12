package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class Acceso extends EdificioUnidadesBasicas implements ElementoProtoss {

	public Acceso() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 8;
		this.unidadesEnProduccion = new ListaMU<Unidad>();
		this.estadoFisico = new Protoss(500,500);
	}
	
	public void crearZealot() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Zealot());
	}
	
	public void crearDragon() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Dragon());
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}
}
