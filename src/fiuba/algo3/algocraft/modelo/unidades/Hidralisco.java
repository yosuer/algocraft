package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;

public class Hidralisco extends Unidad {

	public Hidralisco() {
		this.transporte = 2;
		this.vision = 6;
		this.costoMineral = 75;
		this.costoVespeno = 25;
		this.danioAire = 10;
		this.danioTierra = 10;
		this.suministro = 1;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 4;
		this.estadoFisico = new Zerg(80);
		this.estado = new Construyendose(this,4);
		this.nivel = 0;
	}

}