package fiuba.algo3.algocraft.modelo;


public class FabricaProtoss implements FabricaDeElementos {

	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas() {
		return (new Acceso());
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno() {
		return (new Asimilador());
	}

	@Override
	public BasePrincipal crearBase(Mapa mapa) {
		return (new Nexo());
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral() {
		return (new NexoMineral());
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves() {
		return (new PuertoEstelarProtoss());
	}

	@Override
	public EdificioUnidadesAvanzadas crearEdificioUnidadesAvanzadas() {
		return (new ArchivoTemplario());
	}

	@Override
	public EdificioCasa crearEdificioCasa() {
		return (new Pilon());
	}

}
