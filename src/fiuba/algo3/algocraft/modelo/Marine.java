package fiuba.algo3.algocraft.modelo;


public class Marine extends Unidad {

	public Marine(Mapa mapa) {
		super(mapa);
		this.vida = 40;
	}

	@Override
	public int getNivel() {
		return 0;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {

	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
