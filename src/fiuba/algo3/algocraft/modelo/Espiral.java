package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class Espiral extends EdificioConstructorDeNaves {

	public Espiral() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 13;
		this.unidadesEnProduccion = new ListaMU<Unidad>();
		this.estadoFisico = new Zerg(1300);
	}
	
	public void evolucionarLarvaAMutalisco() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Mutalisco());
	}	
	
	public void evolucionarLarvaAReina() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Reina());
	}	

}
