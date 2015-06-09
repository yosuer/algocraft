package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class Barraca extends EdificioUnidadesBasicas {

	public Barraca() {
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 12;
		this.unidadesDisponibles = new ArrayList<Unidad>();
		this.unidadesDisponibles.add(new Marine());
	}
	
	public Unidad crearMarine() {
		if (this.tiempoDeConstruccion > 0)
			throw new ErrorEdificioEnConstruccion();
		
		return crearUnidad(0);
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
