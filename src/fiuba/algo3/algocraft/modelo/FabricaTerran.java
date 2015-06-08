package fiuba.algo3.algocraft.modelo;


public class FabricaTerran implements FabricaDeElementos{

	public FabricaTerran() {
	}

	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Mapa mapa) {
		return new Barraca(mapa);
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Mapa mapa) {
		return new Refineria(mapa);
	}

	@Override
	public BasePrincipal crearBase(Mapa mapa) {
		return (new CentroDeMando(mapa));
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Mapa mapa) {
		return (new CentroDeMineral(mapa));
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves(Mapa mapa) {
		return (new PuertoEstelarTerran(mapa));
	}

	@Override
	public EdificioUnidadesAvanzadas crearEdificioUnidadesAvanzadas(Mapa mapa) {
		return (new Fabrica(mapa));
	}
	
	
	

}
