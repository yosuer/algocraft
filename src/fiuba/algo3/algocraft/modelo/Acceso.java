package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class Acceso extends EdificioUnidadesBasicas {

	public Acceso() {
		super();
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 8;
		this.nivel = 0;
		this.unidadesEnProduccion = new ListaMU<Unidad>();
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
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}
}
