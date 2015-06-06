package fiuba.algo3.algocraft.modelo;


public class ReservaDeReproduccion extends EdificioUnidadesBasicas {

	public ReservaDeReproduccion(Posicion posicion) {
		super(posicion);
	}

	@Override
	public Unidad crearUnidad() {
		Posicion posElementoCreado = new Posicion(posicion.posX()+1,posicion.posY()+1);
		return new Zerling(posElementoCreado);
	}

	@Override
	public int getNivel() {
		return 0;
	}

}
