package fiuba.algo3.algocraft.modelo;


public class Extractor extends ExtractorDeGasVespeno {

	private int recolectado;
	private Vespeno recurso;

	public Extractor(Mapa mapa) {
		super(mapa);
		this.vida = 900;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 7;
	}

	@Override
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Vespeno)recurso;
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
