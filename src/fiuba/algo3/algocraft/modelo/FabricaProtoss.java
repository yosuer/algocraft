package fiuba.algo3.algocraft.modelo;


public class FabricaProtoss implements FabricaDeElementos {

	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Mapa mapa) {
		return (new Acceso());
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Mapa mapa) {
		return (new Asimilador());
	}

	@Override
	public BasePrincipal crearBase(Mapa mapa) {
		return (new Nexo());
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Mapa mapa) {
		return (new NexoMineral());
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves(Mapa mapa) {
		return (new PuertoEstelarProtoss());
	}

	@Override
	public EdificioUnidadesAvanzadas crearEdificioUnidadesAvanzadas(Mapa mapa) {
		return (new ArchivoTemplario());
	}

	@Override
	public ElementoPoblacion crearEdificioCasa(Mapa mapa) {
		return (new Pilon());
	}

}
