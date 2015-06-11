package fiuba.algo3.algocraft.modelo;

public class AmoSupremo extends Unidad implements ElementoPoblacion {

	public AmoSupremo() {
//		this.transporte =  Capacidad 8 ?
		this.vision = 9;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 10;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.vida = 200;
		this.nivel = 0;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public int getNivel() {
		return 1;
	}

	@Override
	public int getPoblacion() {
		return this.suministro;
	}

}
