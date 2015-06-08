package fiuba.algo3.algocraft.modelo;


public class Zerling extends Unidad {

	public Zerling(Mapa mapa) {
		super(mapa);
		this.vida = 35;
	}

	@Override
	public int getNivel() {
		return 0;
	}
	
	@Override
	public int vidaActual() {
		return this.vida;
	}

}
