package fiuba.algo3.algocraft.modelo;

import java.util.Collection;

public abstract class EdificioUnidadesAvanzadas extends Edificio 
											implements CreadorDeUnidades {

	Collection<Unidad> unidadesDisponibles;
	
	public Collection<Unidad> getUnidadesDisponibles(){
		return this.unidadesDisponibles; 
	}

}
