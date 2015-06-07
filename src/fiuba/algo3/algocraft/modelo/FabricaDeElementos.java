package fiuba.algo3.algocraft.modelo;


public interface FabricaDeElementos {
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Mapa mapa);
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Mapa mapa);
	public BasePrincipal crearBase(Mapa mapa);
	public ExtractorDeMineral crearExtractorDeMineral(Mapa mapa);
}
