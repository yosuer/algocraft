package fiuba.algo3.algocraft.modelo;

public class NaveDeTransporteProtoss extends Unidad {

	public NaveDeTransporteProtoss()
	{
		this.vida = 140;
		this.costoMineral = 200;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 8;
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
