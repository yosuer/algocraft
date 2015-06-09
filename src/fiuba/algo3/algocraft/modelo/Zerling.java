package fiuba.algo3.algocraft.modelo;


public class Zerling extends Unidad {

	public Zerling() {
		this.vida = 35;
		this.costoMineral = 25;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 2;
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
}
