package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public abstract class EdificioUnidadesBasicas extends Edificio implements CreadorDeUnidades{
	
	protected ArrayList<Unidad> colaDeProduccion;
	
	public  EdificioUnidadesBasicas()
	{
		this.colaDeProduccion = new ArrayList<Unidad>();
	}
	/*
	public Collection<Unidad> getUnidadesDisponibles(){
		return this.unidadesDisponibles; 
	}
	
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
