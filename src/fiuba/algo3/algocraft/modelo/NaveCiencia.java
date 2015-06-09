package fiuba.algo3.algocraft.modelo;

public class NaveCiencia extends Unidad {

	private int cargaDeEnergia;
	
	public NaveCiencia() {
		this.transporte = 0;
		this.vision = 10;
		this.costoMineral = 100;
		this.costoVespeno = 225;
		this.tiempoDeConstruccion = 10;
		this.danioAire = 0;
		this.danioTierra = 0;
		this.suministro = 2;
		this.rangoAtaqueAire = 0;
		this.rangoAtaqueTierra = 0;
		this.vida = 200;
		this.nivel = 1;
		
		this.cargaDeEnergia = 0;
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
