package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Zealot extends Unidad implements ElementoProtoss {
	
	public Zealot() {
		super();
		this.nombre = "Zealot";
		this.transporte = 2;
		this.vision = 7;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.suministro = 2;
		this.estadoFisico = new Protoss(100,60);
		this.estado = new Construyendose(this,4);
		this.nivel = 0;
		this.arma = new ArmaSimple(8,0,1,0);
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
