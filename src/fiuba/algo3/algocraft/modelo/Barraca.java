package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class Barraca extends EdificioUnidadesBasicas {

	public Barraca() {
		super();
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 12;
		this.nivel = 0;
	}
	
	public void crearMarine()
	{
		this.colaDeProduccion.add(new Marine());
	}
	
	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}
	
	public void pasarTurno() {
		super.pasarTurno();
		Iterator<Unidad> it= this.colaDeProduccion.iterator();
		while(it.hasNext()) {
			
			Unidad unaUnidad = it.next();
			unaUnidad.pasarTurno();
			
			if (unaUnidad.getTiempoDeConstruccion() == 0) {
//				this.mapa.agregarElemento(5,5,unaUnidad);
				this.colaDeProduccion.remove(unaUnidad);
			}
		}
	}
	
}
