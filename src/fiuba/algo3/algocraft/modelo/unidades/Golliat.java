package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Golliat extends Unidad {

	public Golliat() {
		this.transporte = 2;
		this.vision = 8;
		this.costoMineral = 100;
		this.costoVespeno = 50;
		this.suministro = 2;
		this.estadoFisico = new Terran(125);
		this.estado = new Construyendose(this,6);
		this.nivel = 0;
		this.arma = new ArmaSimple(12,10,6,5);
	}

}
