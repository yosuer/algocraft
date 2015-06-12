package fiuba.algo3.algocraft.modelo;

public abstract class EdificioUnidadesBasicas extends Edificio {
	
	protected ListaMU<Unidad> unidadesEnProduccion;
	
	public void pasarTurno() {
		super.pasarTurno();
		if (!this.unidadesEnProduccion.isEmpty()) {
			if (this.hayUnidadPreparada()){
				this.expulsarUnidad(this.unidadesEnProduccion.desEncolar());
			} else
				this.unidadesEnProduccion.primero().pasarTurno();
			}
		}
	
	protected void expulsarUnidad(Unidad u){
		Posicion pos = new Posicion(2,2,0);
		u.setPosicion(pos);
		this.mapa.encolarUnidad(u);
	}
	
	public boolean hayUnidadPreparada(){
		return unidadesEnProduccion.primero().getTiempoDeConstruccion() == 0;
	}
	
	public int unidadesEnProduccion(){
		return this.unidadesEnProduccion.size();
	}
	/*
	
	@Override
	public Unidad crearUnidad(int i) {
		if (this.tiempoDeConstruccion > 0)
			throw new ErrorEdificioEnConstruccion();
		try {
			Unidad u;
			u = this.unidadesDisponibles.get(i).getClass().newInstance();
			return u;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	*/

}
