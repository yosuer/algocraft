package fiuba.algo3.algocraft.modelo;


public class NexoMineral extends ExtractorDeMineral {

	public NexoMineral(Mapa mapa) {
		super(mapa);
		this.recolectado = 0;
		this.vida = 500;
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
