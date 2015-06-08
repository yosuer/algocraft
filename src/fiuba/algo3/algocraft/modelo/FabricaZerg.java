package fiuba.algo3.algocraft.modelo;


public class FabricaZerg implements FabricaDeElementos{

	public FabricaZerg(){
	}
	
	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Mapa mapa) {
		return (new CentroDeReproduccion(mapa));
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Mapa mapa) {
		return (new Extractor(mapa));
	}

	@Override
	public BasePrincipal crearBase(Mapa mapa) {
		return (new Criadero(mapa));
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Mapa mapa) {
		return (new ZergMineral(mapa));
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves(Mapa mapa) {
		return new Espiral(mapa);
	}
	

}
