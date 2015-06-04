package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.Asimilador;
import fiuba.algo3.algocraft.modelo.edificios.BasePrincipal;
import fiuba.algo3.algocraft.modelo.edificios.EdificioUnidadesBasicas;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.Nexo;
import fiuba.algo3.algocraft.modelo.edificios.NexoMineral;

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
