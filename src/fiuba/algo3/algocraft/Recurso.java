package fiuba.algo3.algocraft;

public interface Recurso {
	
	public int reservaDisponible();

	public int extraer();

	public void asignarExtractor(ExtractorDeRecursos extractor);

	public ExtractorDeRecursos getExtractor();
}
