package fiuba.algo3.algocraft.modelo;


public class Mutalisco extends Unidad {

	public Mutalisco() {
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 100;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 6;
		this.danioAire = 9;
		this.danioTierra = 9;
		this.suministro = 2;
		this.rangoAtaqueAire = 3;
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