package fiuba.algo3.algocraft.modelo;


public class Marine extends Unidad {

	public Marine() {
		this.vida = 40;
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 3;
		this.nivel = 0;
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
