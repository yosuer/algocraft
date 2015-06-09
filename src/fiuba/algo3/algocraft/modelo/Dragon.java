package fiuba.algo3.algocraft.modelo;

public class Dragon extends Unidad {

	public Dragon(){
		this.transporte = 4;
		this.vision = 8;
		this.costoMineral = 125;
		this.costoVespeno = 50;
		this.tiempoDeConstruccion = 6;
		this.danioAire = 20;
		this.danioTierra = 20;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 4;
		this.vida = 180;
		this.nivel = 0;
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
