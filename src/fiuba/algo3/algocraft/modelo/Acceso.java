package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;


public class Acceso extends EdificioUnidadesBasicas {

	
	public Acceso() {
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 8;
		this.unidadesDisponibles = new ArrayList<Unidad>();
		this.unidadesDisponibles.add(new Zealot());
		this.unidadesDisponibles.add(new Dragon());
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

	public Unidad crearZealot() {
		if (this.tiempoDeConstruccion > 0)
			throw new ErrorEdificioEnConstruccion();
		
		return crearUnidad(0);
	}

}
