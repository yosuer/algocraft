package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Construyendose;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;

public class NaveDeTransporteProtoss extends Unidad implements ElementoProtoss {

	public NaveDeTransporteProtoss() {
		this.transporte = 8;
		this.vision = 8;
		this.costoMineral = 200;
		this.costoVespeno = 0;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Protoss(80,60);
		this.estado = new Construyendose(this,8);
		this.nivel = 0;
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
