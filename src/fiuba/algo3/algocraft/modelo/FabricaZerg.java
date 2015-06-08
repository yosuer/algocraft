package fiuba.algo3.algocraft.modelo;


public class FabricaZerg implements FabricaDeElementos{

	public FabricaZerg(){
	}
	
	@Override
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas() {
		return (new ReservaDeReproduccion());
	}

	@Override
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno() {
		return (new Extractor());
	}

	@Override
	public BasePrincipal crearBase() {
		return (new Criadero());
	}

	@Override
	public ExtractorDeMineral crearExtractorDeMineral() {
		return (new ZergMineral());
	}

	@Override
	public EdificioConstructorDeNaves crearEdificioCreadorDeNaves() {
		return (new Espiral());
	}

	@Override
	public EdificioUnidadesAvanzadas crearEdificioUnidadesAvanzadas() {
		return (new GuaridaDeHidralisco());
	}

	@Override
	public EdificioCasa crearEdificioCasa() {
		return (new AmoSupremo());
	}
	

}
