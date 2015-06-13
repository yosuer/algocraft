package fiuba.algo3.algocraft.modelo;

import java.util.EmptyStackException;

public class CreadorEnCola implements ICreadorDeElementos {

	private ListaMU<Unidad> unidadesEnProduccion;
	private IElementoCreador elemento;
	
	public CreadorEnCola(IElementoCreador elemento){
		this.elemento = elemento;
		unidadesEnProduccion = new ListaMU<Unidad>();
	}
	
	@Override
	public void prepararUnidad(Unidad u) {
		this.unidadesEnProduccion.encolar(u);
	}

	@Override
	public void expulsarUnidad() {
		try {
			elemento.enviarUnidadAlMapa(unidadesEnProduccion.desEncolar());
			this.unidadesEnProduccion.primero().pasarTurno();
		} catch (IndexOutOfBoundsException e1){
		} catch (EmptyStackException e2){
		}
	}
	
	public int unidadesEnProduccion(){
		return this.unidadesEnProduccion.size();
	}

}
