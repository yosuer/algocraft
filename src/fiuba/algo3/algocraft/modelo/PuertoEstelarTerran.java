package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;


public class PuertoEstelarTerran extends EdificioConstructorDeNaves {

	public PuertoEstelarTerran() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
		this.edificiosRequeridos.add(new Fabrica());
		this.unidadesEnProduccion = new ListaMU<Unidad>();
		this.estadoFisico = new Terran(1300);
	}
	
	public void crearEspectro() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new Espectro());
	}
	
	public void crearNaveCiencia() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new NaveCiencia());
	}
	
	public void crearNaveDeTransporteTerran() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new NaveTransporteTerran());
	}

}
