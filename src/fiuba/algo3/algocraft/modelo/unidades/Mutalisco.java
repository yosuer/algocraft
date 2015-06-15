package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;

public class Mutalisco extends Unidad {

	public Mutalisco() {
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 6;
		this.danioAire = 9;
		this.danioTierra = 9;
		this.suministro = 2;
		this.rangoAtaqueAire = 3;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Zerg(120);
		this.nivel = 1;
	}

}