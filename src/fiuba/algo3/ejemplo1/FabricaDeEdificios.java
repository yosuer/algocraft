package fiuba.algo3.ejemplo1;

public abstract class FabricaDeEdificios extends Elemento{

	public FabricaDeEdificios(Posicion posicion) {
		super(posicion);
	}
	
	public abstract FabricaUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos);
	public abstract ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos);
}
