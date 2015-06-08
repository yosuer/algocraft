package fiuba.algo3.algocraft.modelo;


public class ReservaDeReproduccion extends EdificioUnidadesBasicas {

	public ReservaDeReproduccion() {
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 10;
	}

	@Override
	public Unidad crearUnidad() {
		return new Zerling();
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
