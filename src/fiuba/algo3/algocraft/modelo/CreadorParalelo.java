package fiuba.algo3.algocraft.modelo;

import java.util.LinkedList;
import java.util.List;

public class CreadorParalelo implements ICreadorDeElementos{
	
	private List<Controlable> unidades;
	private IElementoCreador elemento;
	
	public CreadorParalelo(IElementoCreador elementoCreador){
		this.elemento = elementoCreador;
		this.unidades = new LinkedList<Controlable>();
	}

	@Override
	public void prepararUnidad(Unidad u) {
		this.unidades.add(u);
	}

	@Override
	public void expulsarUnidad() {
//		try {
//			elemento.enviarUnidadAlMapa(this.unidades.remove());
//			this.unidades.element().pasarTurno();
//		} catch (NoSuchElementException e1){
//		}
	}

	@Override
	public int unidadesEnProduccion() {
		return unidades.size();
	}
	
	
}
