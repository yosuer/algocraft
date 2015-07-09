package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Marine extends Unidad {

	public Marine() {
		super();
		this.nombre = "Marine";
		this.transporte = 1;
		this.vision = 7;
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.suministro = 1;
		this.estadoFisico = new Terran(40);
		this.estado = new Construyendose(this, 3);
		this.nivel = 0;
		this.arma = new ArmaSimple(6, 6, 4, 4); // dA dT rAA rAT
	}

}
