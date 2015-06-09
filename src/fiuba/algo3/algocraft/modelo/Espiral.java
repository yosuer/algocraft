package fiuba.algo3.algocraft.modelo;


public class Espiral extends EdificioConstructorDeNaves {

	public Espiral() {
		super();
		this.vida = 1200;
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 10;
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
