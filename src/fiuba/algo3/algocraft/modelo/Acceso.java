package fiuba.algo3.algocraft.modelo;


public class Acceso extends EdificioUnidadesBasicas {

	public Acceso(Posicion posicion) {
		super(posicion);
	}
	
	@Override
	public Unidad crearUnidad() {
		Posicion posElementoCreado = new Posicion(posicion.posX()+1,posicion.posY()+1);
		return new Zealot(posElementoCreado);
	}

	@Override
	public int getNivel() {
		return 0;
	}

}
