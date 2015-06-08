package fiuba.algo3.algocraft.modelo;


public class Zerling extends Unidad {

	public Zerling() {
		this.vida = 35;
		this.nivel = 0;
	}

	@Override
	public int getNivel() {
		return 0;
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
