package fiuba.algo3.algocraft.modelo;

public class Espectro extends Unidad {

	public Espectro() {
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 8;
		this.danioAire = 20;
		this.danioTierra = 8;
		this.suministro = 2;
		this.rangoAtaqueAire = 5;
		this.rangoAtaqueTierra = 0;
		this.vida = 120;
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
