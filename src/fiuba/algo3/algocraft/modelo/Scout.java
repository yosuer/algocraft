package fiuba.algo3.algocraft.modelo;

public class Scout extends Unidad {

	public Scout() {
		this.transporte = 0;
		this.vision = 7;
		this.costoMineral = 300;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 9;
		this.danioAire = 14;
		this.danioTierra = 8;
		this.suministro = 3;
		this.rangoAtaqueAire = 4;
		this.rangoAtaqueTierra = 0;
		this.vida = 250;
		this.nivel = 1;
	}
	
	@Override
	public int getNivel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int vidaActual() {
		// TODO Auto-generated method stub
		return 0;
	}

}
