package fiuba.algo3.algocraft.modelo;

public class Zerling extends Unidad {

	public Zerling() {
		this.transporte = 1;
		this.vision = 5;
		this.costoMineral = 25;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 2;
		this.danioAire = 0;
		this.danioTierra = 5;
		this.suministro = 1/2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 1;
		this.estadoFisico = new Zerg(35);
		this.nivel = 0;
	}

}
