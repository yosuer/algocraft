package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.edificios.BasePrincipal;
import fiuba.algo3.algocraft.modelo.edificios.EdificioUnidadesBasicas;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeGasVespeno;
import fiuba.algo3.algocraft.modelo.edificios.ExtractorDeMineral;

public interface FabricaDeElementos {
	public EdificioUnidadesBasicas crearFabricaUnidadesBasicas(Posicion pos);
	public ExtractorDeGasVespeno crearExtractorDeGasVespeno(Posicion pos);
	public BasePrincipal crearBase(Posicion pos);
	public ExtractorDeMineral crearExtractorDeMineral(Posicion pos);
}
