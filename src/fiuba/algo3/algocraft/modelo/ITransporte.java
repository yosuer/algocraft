package fiuba.algo3.algocraft.modelo;

import java.util.Collection;

public interface ITransporte {

	public void transportar(ITransportable elemento);
	
	public Collection<ITransportable> descargar();
}
