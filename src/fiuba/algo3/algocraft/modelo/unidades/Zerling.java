package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;

public class Zerling extends Unidad {

	public Zerling() {
		this.transporte = 1;
		this.vision = 5;
		this.costoMineral = 25;
		this.costoVespeno = 0;
		this.danioAire = 0;
		this.danioTierra = 5;
		this.suministro = 1/2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 1;
		this.estadoFisico = new Zerg(35);
		this.nivel = 0;
		this.estado = new Construyendose(this,2);
	}

}
