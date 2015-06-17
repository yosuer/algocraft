package fiuba.algo3.algocraft.modelo;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CreadorEnCola implements ICreadorDeElementos {

	private IElementoCreador elemento;
	private Queue<Unidad> unidades;
	private int maxUnidades;
	
	public CreadorEnCola(IElementoCreador elementoCreador){
		this.elemento = elementoCreador;
		unidades = new LinkedList<Unidad>();
		this.maxUnidades = 4;
	}
	
	@Override
	public void prepararUnidad(Unidad u) {
		if (this.unidades.size() < this.maxUnidades)
			this.unidades.add(u);
	}

	@Override
	public void expulsarUnidad() {
		try {
			if (unidades.element().listaParaSalir())
					elemento.enviarUnidadAlMapa(this.unidades.remove());
			this.unidades.element().pasarTurno();
		} catch (NoSuchElementException e1){
		}
	}
	
	@Override
	public int unidadesEnProduccion(){
		return this.unidades.size();
	}

}
