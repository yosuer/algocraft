package fiuba.algo3.algocraft.modelo;

public class NaveTransporteTerran extends Unidad {

	public NaveTransporteTerran() {
		this.transporte = 8;
		this.vision = 8;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 7;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.estadoFisico = new Terran(150);
		this.nivel = 0;
	}

}
