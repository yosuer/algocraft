package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class GuaridaDeHidralisco extends EdificioUnidadesAvanzadas {

	public GuaridaDeHidralisco() {
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
		this.edificiosRequeridos.add(new ReservaDeReproduccion());
		this.unidadesEnProduccion = new ListaMU<Unidad>();
		this.estadoFisico = new Zerg(1250);
	}

	//Faltaría poner que se hace Hidralisco a raíz de una Larva
	public void evolucionarLarva() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Hidralisco());
	}
	
}
