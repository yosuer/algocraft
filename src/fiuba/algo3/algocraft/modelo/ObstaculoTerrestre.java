package fiuba.algo3.algocraft.modelo;


public class ObstaculoTerrestre implements IElemento {
	
	Posicion pos;
	int nivel;
	
	public ObstaculoTerrestre() {
	}

	@Override
	public Posicion getPosicion() {
		return pos;
	}

	@Override
	public void setPosicion(Posicion posicion) {
		this.pos = posicion;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {
		
	}

	@Override
	public int getNivel() {
		return nivel;
	}

}
