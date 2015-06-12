package fiuba.algo3.algocraft.modelo;

public class Golliat extends Unidad {

	public Golliat() {
		this.transporte = 2;
		this.vision = 8;
		this.costoMineral = 100;
		this.costoVespeno = 50;
		this.tiempoDeConstruccion = 6;
		this.danioAire = 10;
		this.danioTierra = 12;
		this.suministro = 2;
		this.rangoAtaqueAire = 5;
		this.rangoAtaqueTierra = 6;
		this.estadoFisico = new Terran(125);
		this.nivel = 0;
	}

}
