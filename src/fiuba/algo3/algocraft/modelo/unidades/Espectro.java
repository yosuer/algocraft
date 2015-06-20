package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Espectro extends Unidad {

	public Espectro() {
		super();
		this.nombre = "Espectro";
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.suministro = 2;
		this.estadoFisico = new Terran(120);
		this.nivel = 1;
		this.estado = new Construyendose(this,8);
		this.arma = new ArmaSimple(8,20,5,5);
	}

}
