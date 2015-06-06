package fiuba.algo3.algocraft.modelo;


public class FabricaProtoss implements FabricaDeElementos {

	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos) {
		return (new Acceso(pos));
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos) {
		return (new Asimilador(pos));
	}

	@Override
	public BasePrincipal crearBase(Posicion pos) {
		return (new Nexo(pos));
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Posicion pos) {
		return (new NexoMineral(pos));
	}

}
