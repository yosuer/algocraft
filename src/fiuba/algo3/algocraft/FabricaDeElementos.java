package fiuba.algo3.algocraft;

public interface FabricaDeElementos {
	public FabricaUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos);
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos);
	public BasePrincipal crearBase(Posicion pos);
	public ExtractorDeMineral crearExtractorDeMineral(Posicion pos);
}
