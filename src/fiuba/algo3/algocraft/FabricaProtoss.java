package fiuba.algo3.algocraft;

public class FabricaProtoss implements FabricaDeElementos {

	@Override
	public FabricaUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos) {
		return (new Acceso(pos));
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos) {

		return null;
	}

}
