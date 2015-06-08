package fiuba.algo3.algocraft.modelo;

public class Barraca extends EdificioUnidadesBasicas {

	public Barraca() {
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 12;
	}
	
	@Override
	public Unidad crearUnidad() {
		return new Marine();
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
