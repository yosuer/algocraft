package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.Protoss;
import fiuba.algo3.algocraft.modelo.Unidad;

public class AltoTemplario extends Unidad implements ElementoProtoss {

	public AltoTemplario() {
		this.transporte = 2;
		this.vision = 7;
		this.costoMineral = 50;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 7;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Protoss(40,40);
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
