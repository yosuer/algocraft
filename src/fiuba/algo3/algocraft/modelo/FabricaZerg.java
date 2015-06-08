package fiuba.algo3.algocraft.modelo;


public class FabricaZerg implements FabricaDeElementos{

	public FabricaZerg(){
	}
	
	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Mapa mapa) {
		return (new ReservaDeReproduccion());
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Mapa mapa) {
		return (new Extractor());
	}

	@Override
	public BasePrincipal crearBase(Mapa mapa) {
		return (new Criadero());
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Mapa mapa) {
		return (new ZergMineral());
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves(Mapa mapa) {
		return (new Espiral());
	}

	@Override
	public EdificioUnidadesAvanzadas crearEdificioUnidadesAvanzadas(Mapa mapa) {
		return (new GuaridaDeHidralisco());
	}

	@Override
	public EdificioCasa crearEdificioCasa(Mapa mapa) {
		return (new AmoSupremo());
	}
	

}
