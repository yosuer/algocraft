package fiuba.algo3.algocraft.modelo;

public class NaveTransporte extends Unidad{

	public NaveTransporte() {
		this.nivel = 1;
		this.vida = 150;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {
		
	}

	@Override
	public int getNivel() {
		return 0;
	}

	@Override
	public int vidaActual() {
		return 0;
	}

}
