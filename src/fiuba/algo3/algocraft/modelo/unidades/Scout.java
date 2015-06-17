package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Scout extends Unidad implements ElementoProtoss {

	public Scout() {
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 300;
		this.costoVespeno = 150;
		this.suministro = 3;
		this.estadoFisico = new Protoss(150,100);
		this.estado = new Construyendose(this,9);
		this.nivel = 1;
		this.arma = new ArmaSimple(8,14,0,4);
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

}
