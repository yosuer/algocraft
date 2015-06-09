package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

public abstract class EdificioConstructorDeNaves extends Edificio implements CreadorDeUnidades {

	protected ArrayList<Unidad> colaDeProduccion;
	
	public EdificioConstructorDeNaves()
	{
		this.colaDeProduccion= new ArrayList<Unidad>();
	}

}
