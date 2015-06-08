package fiuba.algo3.algocraft.modelo;

public class Espectro extends Unidad {

	public Espectro() {
		this.nivel = 1;
		this.vida = 120;
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public void agregarseEn(Mapa mapa) {
		// TODO Auto-generated method stub
		
	}

}
