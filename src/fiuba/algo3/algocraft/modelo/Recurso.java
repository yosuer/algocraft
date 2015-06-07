package fiuba.algo3.algocraft.modelo;


public abstract class Recurso {
	
	protected Mapa mapa;
	protected int reserva;
	protected Posicion posicion;
	protected int nivel = 0;
	
	public Recurso(Mapa mapa){
		this.mapa = mapa;
	}
	
	public abstract int reservaDisponible();

	public abstract int extraer();

	public abstract void asignarExtractor(ExtractorDeRecursos extractor);

	public abstract ExtractorDeRecursos getExtractor();
	
	public boolean moverseA(Posicion posicion){
		return false;
	}

}
