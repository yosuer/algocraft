package fiuba.algo3.algocraft.modelo;

public class PuertoEstelarProtoss extends EdificioConstructorDeNaves {

	public PuertoEstelarProtoss() {
		this.vida = 1200;
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 10;
		this.edificiosRequeridos.add(new Fabrica());
	}

	@Override
	public Unidad crearUnidad(int i) {
		return null;
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
