package fiuba.algo3.algocraft.modelo;

public class Espectro extends Unidad {

	public Espectro(Mapa mapa) {
		super(mapa);
		this.nivel = 1;
		this.vida = 120;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {

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
