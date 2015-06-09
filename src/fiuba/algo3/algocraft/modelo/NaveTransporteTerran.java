package fiuba.algo3.algocraft.modelo;

public class NaveTransporteTerran extends Unidad{

	public NaveTransporteTerran() {
//		this.transporte = 2; Dice capacidad 8 -> REVISAR
		this.vision = 8;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 7;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.vida = 150;
		this.nivel = 1; //Si dice capacidad 8, es terrestre o aéreo?
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
