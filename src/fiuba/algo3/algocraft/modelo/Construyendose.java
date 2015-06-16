package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class Construyendose implements IEstado {

	private int tiempoDeConstruccion;
	private Controlable elemento;

	public Construyendose(Controlable elemento, int tiempo) {
		this.tiempoDeConstruccion = tiempo;
		this.elemento = elemento;
	}

	@Override
	public void pasarTurno() {
		this.tiempoDeConstruccion--;
		if (this.tiempoDeConstruccion == 0) 
			elemento.actualizarEstado(new Activo(elemento));
	}

	@Override
	public void estaActivo() {
		throw new ErrorEdificioEnConstruccion();
	}

}
