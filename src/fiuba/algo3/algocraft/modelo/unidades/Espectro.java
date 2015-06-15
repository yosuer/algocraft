package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Espectro extends Unidad {

	public Espectro() {
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 8;
		this.danioAire = 20;
		this.danioTierra = 8;
		this.suministro = 2;
		this.rangoAtaqueAire = 5;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Terran(120);
		this.nivel = 1;
	}

}
