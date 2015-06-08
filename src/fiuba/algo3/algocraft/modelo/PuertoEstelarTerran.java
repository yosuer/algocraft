package fiuba.algo3.algocraft.modelo;


public class PuertoEstelarTerran extends EdificioConstructorDeNaves {

	public PuertoEstelarTerran() {
		this.vida = 1300;
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
	}

	@Override
	public Unidad crearUnidad() {
		return new Espectro();
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
