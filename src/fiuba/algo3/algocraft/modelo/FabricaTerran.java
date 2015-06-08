package fiuba.algo3.algocraft.modelo;


public class FabricaTerran implements FabricaDeElementos{

	public FabricaTerran() {
	}

	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas() {
		return new Barraca();
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno() {
		return new Refineria();
	}

	@Override
	public BasePrincipal crearBase() {
		return (new CentroDeMando());
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral() {
		return (new CentroDeMineral());
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves() {
		return (new PuertoEstelarTerran());
	}

	@Override
	public EdificioUnidadesAvanzadas crearEdificioUnidadesAvanzadas() {
		return (new Fabrica());
	}

	@Override
	public EdificioCasa crearEdificioCasa() {
		return (new DepositoDeSuministros());
	}
	
	
	

}
