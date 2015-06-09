package fiuba.algo3.algocraft.modelo;

public class Dragon extends Unidad {

	public Dragon(){
		this.tiempoDeConstruccion = 6;
		this.vida = 180;
		this.costoMineral = 125;
		this.costoVespeno = 50;
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
