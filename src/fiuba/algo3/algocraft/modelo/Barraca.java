package fiuba.algo3.algocraft.modelo;


public class Barraca extends EdificioUnidadesBasicas {

	public Barraca(Posicion posicion) {
		super(posicion);
	}

	@Override
	public Unidad crearUnidad() {
		Posicion posElementoCreado = new Posicion(posicion.posX()+1,posicion.posY()+1);
		return new Marine(posElementoCreado);
	}

	@Override
	public int getNivel() {
		return 0;
	}

}
