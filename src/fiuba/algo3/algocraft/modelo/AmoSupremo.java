package fiuba.algo3.algocraft.modelo;

public class AmoSupremo extends EdificioCasa implements Unidad {

	public AmoSupremo() {
//		this.transporte =  Capacidad 8 ?
		this.vision = 9;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 4;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 0;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.vida = 200;
		this.nivel = 0;
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
