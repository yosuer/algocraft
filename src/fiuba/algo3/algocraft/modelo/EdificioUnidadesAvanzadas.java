package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

public abstract class EdificioUnidadesAvanzadas extends Edificio implements CreadorDeUnidades {

	protected ArrayList<Unidad> colaDeProduccion;
	
	public EdificioUnidadesAvanzadas()
	{
		this.colaDeProduccion= new ArrayList<Unidad>();
	}
	
	
}
