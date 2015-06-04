package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.BasePrincipal;
import fiuba.algo3.algocraft.modelo.edificios.Criadero;
import fiuba.algo3.algocraft.modelo.edificios.EdificioUnidadesBasicas;
import fiuba.algo3.algocraft.modelo.edificios.Extractor;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.ReservaDeReproduccion;
import fiuba.algo3.algocraft.modelo.edificios.ZergMineral;

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
