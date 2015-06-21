package fiuba.algo3.algocraft.modelo;

public abstract class Recurso extends Estatico {
	
	protected int reserva;

	public abstract int reservaDisponible();

	public abstract int extraer();

	public abstract void asignarExtractor(IExtractorDeRecursos extractor);

	public abstract IExtractorDeRecursos getExtractor();
	
	@Override
	public void eliminarseDelMapa(Mapa mapa) {
		this.mapa.quitarElemento(this);
	}

}
