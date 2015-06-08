package fiuba.algo3.algocraft.modelo;

public class AltoTemplario extends Unidad {

	public AltoTemplario(Mapa mapa) {
		super(mapa);
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
