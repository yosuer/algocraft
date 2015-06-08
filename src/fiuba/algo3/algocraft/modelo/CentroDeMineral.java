package fiuba.algo3.algocraft.modelo;


public class CentroDeMineral extends ExtractorDeMineral {

	public CentroDeMineral() {
		this.vida = 300;
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
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
