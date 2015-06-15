package fiuba.algo3.algocraft.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class CreadorParalelo implements ICreadorDeElementos{
	
	private List<IElemento> unidades;
	private IElementoCreador elemento;
	
	public CreadorParalelo(IElementoCreador elementoCreador){
		this.elemento = elementoCreador;
		this.unidades = new LinkedList<IElemento>();
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
	
	
}
