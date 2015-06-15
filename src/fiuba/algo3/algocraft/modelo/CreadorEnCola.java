package fiuba.algo3.algocraft.modelo;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CreadorEnCola implements ICreadorDeElementos {

	private IElementoCreador elemento;
	private Queue<Unidad> unidades;
	
	public CreadorEnCola(IElementoCreador elementoCreador){
		this.elemento = elementoCreador;
		unidades = new LinkedList<Unidad>();
	}
	
	@Override
	public void prepararUnidad(Unidad u) {
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
	
	public int unidadesEnProduccion(){
		return this.unidades.size();
	}

}
