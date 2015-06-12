package fiuba.algo3.algocraft.modelo;

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
		if (!this.unidadesEnProduccion.isEmpty()) {
			if (this.hayUnidadPreparada()){
				elemento.expulsarUnidad(this.unidadesEnProduccion.desEncolar());
			} else
				this.unidadesEnProduccion.primero().pasarTurno();
			}
	}
	
	public boolean hayUnidadPreparada(){
		return unidadesEnProduccion.primero().getTiempoDeConstruccion() == 0;
	}
	
	public int unidadesEnProduccion(){
		return this.unidadesEnProduccion.size();
	}

}
