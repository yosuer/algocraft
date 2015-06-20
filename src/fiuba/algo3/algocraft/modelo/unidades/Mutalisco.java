package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Zerg;

public class Mutalisco extends Unidad {

	public Mutalisco() {
		super();
		this.nombre = "Mutalisco";
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.suministro = 2;
		this.estadoFisico = new Zerg(120);
		this.estado = new Construyendose(this,6);
		this.nivel = 1;
		this.arma = new ArmaSimple(9,9,0,3);
	}

}