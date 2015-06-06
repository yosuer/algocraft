package fiuba.algo3.algocraft.modelo;


public class FabricaTerran implements FabricaDeElementos{

	public FabricaTerran() {
	}

	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos) {
		return (new Barraca(pos));
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos) {
		return (new Refineria(pos));
	}

	@Override
	public BasePrincipal crearBase(Posicion pos) {
		return (new CentroDeMando(pos));
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Posicion pos) {
		return (new CentroDeMineral(pos));
	}

}
