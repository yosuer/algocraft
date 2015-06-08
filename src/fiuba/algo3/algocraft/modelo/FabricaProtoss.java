package fiuba.algo3.algocraft.modelo;


public class FabricaProtoss implements FabricaDeElementos {

	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Mapa mapa) {
		return (new Acceso(mapa));
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Mapa mapa) {
		return (new Asimilador(mapa));
	}

	@Override
	public BasePrincipal crearBase(Mapa mapa) {
		return (new Nexo(mapa));
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Mapa mapa) {
		return (new NexoMineral(mapa));
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves(Mapa mapa) {
		return (new PuertoEstelarProtoss(mapa));
	}

	@Override
	public EdificioUnidadesAvanzadas crearEdificioUnidadesAvanzadas(Mapa mapa) {
		return (new ArchivoTemplario(mapa));
	}

}
