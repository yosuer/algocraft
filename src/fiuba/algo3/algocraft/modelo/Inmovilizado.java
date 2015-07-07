package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorUnidadInmovilizada;

public class Inmovilizado implements IEstado {

	private int turnosRestantes;
	private Unidad unidad;
	
	public Inmovilizado(Unidad unidad)
	{
		this.turnosRestantes = 3;
		this.unidad = unidad;
	}
	
	@Override
	public void pasarTurno() {
		this.turnosRestantes--;
		if(this.turnosRestantes == 0)
		{
			this.unidad.actualizarEstado(new Activo(this.unidad));
		}
	}

	@Override
	public void estaActivo() {
		throw new ErrorUnidadInmovilizada();
	}

}
