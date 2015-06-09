package fiuba.algo3.algocraft.modelo;

import java.util.Collection;


public interface CreadorDeUnidades {
	
	public Unidad crearUnidad(int indice);
	
	public Collection<Unidad> getUnidadesDisponibles();
	
}
