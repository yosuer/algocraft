package fiuba.algo3.algocraft;

public abstract class FabricaDeEdificios extends Elemento{

	public FabricaDeEdificios(Posicion posicion) {
		super(posicion);
	}
	
	public abstract FabricaUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos);
	public abstract ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos);
}
