package fiuba.algo3.ejemplo1;

public class FabricaTerran extends FabricaDeEdificios{

	public FabricaTerran(Posicion posicion) {
		super(posicion);
	}

	@Override
	public FabricaUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos) {
		return (new Barraca(pos));
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos) {
		return (new Refineria(pos));
	}

}
