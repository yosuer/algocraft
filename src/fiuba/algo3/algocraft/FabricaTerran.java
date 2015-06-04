package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.BasePrincipal;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.EdificioUnidadesBasicas;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.Refineria;

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
