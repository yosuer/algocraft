package fiuba.algo3.algocraft.modelo;

public class NaveDeTransporteProtoss extends Unidad {

	public NaveDeTransporteProtoss() {
//		this.transporte = 2;
		this.vision = 8;
		this.costoMineral = 200;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 8;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.vida = 140;
		this.nivel = 1;
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
