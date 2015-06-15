package fiuba.algo3.algocraft.modelo.unidades;

import fiuba.algo3.algocraft.modelo.Terran;
import fiuba.algo3.algocraft.modelo.Unidad;

public class NaveCiencia extends Unidad {

	private int capacidadMaximaEnergia;
	private int cargaDeEnergia;
	
	public NaveCiencia() {
		this.transporte = 0;
		this.vision = 10;
		this.costoMineral = 100;
		this.costoVespeno = 225;
		this.tiempoDeConstruccion = 10;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Terran(200);
		this.nivel = 1;
		
		this.capacidadMaximaEnergia = 200;
		this.cargaDeEnergia = 50;
	}

}
