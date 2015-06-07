package fiuba.algo3.algocraft.modelo;


public class Extractor extends ExtractorDeGasVespeno {

	private int recolectado;
	private Vespeno recurso;

	public Extractor(Mapa mapa) {
		super(mapa);
	}

	@Override
	public void asignarRecurso(Recurso recurso) {
		this.recurso = (Vespeno)recurso;
	}

	@Override
	public int getNivel() {
		return 0;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int vidaActual() {
		// TODO Auto-generated method stub
		return 0;
	}

}
