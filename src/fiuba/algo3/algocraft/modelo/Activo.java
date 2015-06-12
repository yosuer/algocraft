package fiuba.algo3.algocraft.modelo;

public class Activo implements IEstado {

	private IElemento elemento;
	
	public Activo(IElemento elemento) {
		this.elemento = elemento;
	}

	@Override
	public void pasarTurno() {
		this.elemento.ejecutarAcciones();
	}

	@Override
	public void estaActivo() {
		
	}

}
