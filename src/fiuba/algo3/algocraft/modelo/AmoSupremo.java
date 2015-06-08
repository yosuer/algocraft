package fiuba.algo3.algocraft.modelo;

public class AmoSupremo extends EdificioCasa {

	public AmoSupremo() {
		this.vida = 700;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 7;	
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
