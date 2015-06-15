package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.IEstado;
import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Marine extends Unidad {

	public Marine() {
		this.transporte = 1;
		this.vision = 7;
		this.costoMineral = 50;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 3;
		this.danioAire = 6;
		this.danioTierra = 6;
		this.suministro = 1;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 4;
		this.estadoFisico = new Terran(40);
		this.estado = new Construyendose(this,3);
		this.nivel = 0;
	}
}
