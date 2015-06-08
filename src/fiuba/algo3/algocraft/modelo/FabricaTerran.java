package fiuba.algo3.algocraft.modelo;


public class FabricaTerran implements FabricaDeElementos{

	public FabricaTerran() {
	}

	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Mapa mapa) {
		return new Barraca();
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Mapa mapa) {
		return new Refineria();
	}

	@Override
	public BasePrincipal crearBase(Mapa mapa) {
		return (new CentroDeMando());
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Mapa mapa) {
		return (new CentroDeMineral());
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves(Mapa mapa) {
		return (new PuertoEstelarTerran());
	}

	@Override
	public EdificioUnidadesAvanzadas crearEdificioUnidadesAvanzadas(Mapa mapa) {
		return (new Fabrica());
	}

	@Override
	public EdificioCasa crearEdificioCasa(Mapa mapa) {
		return (new DepositoDeSuministros());
	}
	
	
	

}
