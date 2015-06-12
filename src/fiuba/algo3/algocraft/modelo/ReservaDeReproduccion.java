package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class ReservaDeReproduccion extends EdificioUnidadesBasicas {

	public ReservaDeReproduccion() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 10;
		this.unidadesEnProduccion = new ListaMU<Unidad>();
		this.estadoFisico = new Zerg(1000);
	}

	//Faltar�a poner que se hace Zerling a ra�z de una Larva
	public void evolucionarLarva() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Zerling());
	}

}
