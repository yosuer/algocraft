package fiuba.algo3.algocraft.modelo;


public class FabricaZerg implements FabricaDeElementos{

	public FabricaZerg(){
	}
	
	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos) {
		return (new ReservaDeReproduccion(pos));
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos) {
		return (new Extractor(pos));
	}

	@Override
	public BasePrincipal crearBase(Posicion pos) {
		return (new Criadero(pos));
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral(Posicion pos) {
		return (new ZergMineral(pos));
	}

}
