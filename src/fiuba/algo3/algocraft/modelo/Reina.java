package fiuba.algo3.algocraft.modelo;


public class Reina extends Unidad {

	public Reina() {
		this.transporte = 0;
		this.vision = 10;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 7;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.vida = 120;
		this.nivel = 1;
	}

	@Override
	public int getNivel() {
		return 0;
	}
	
	@Override
	public int vidaActual() {
		return this.vida;
	}
}