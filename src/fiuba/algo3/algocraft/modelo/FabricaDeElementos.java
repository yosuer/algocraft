package fiuba.algo3.algocraft.modelo;


public interface FabricaDeElementos {
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos);
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos);
	public BasePrincipal crearBase(Posicion pos);
	public ExtractorDeMineral crearExtractorDeMineral(Posicion pos);
}
