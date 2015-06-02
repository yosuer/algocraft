package fiuba.algo3.algocraft;

public interface Recurso {
	
	public int reservaDisponible();

	public int extraer();

	public void asignarExtractor(ExtractorDeMineral extractor);

	public ExtractorDeMineral getExtractor();
}
