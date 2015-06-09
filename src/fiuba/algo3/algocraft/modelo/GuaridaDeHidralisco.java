package fiuba.algo3.algocraft.modelo;

public class GuaridaDeHidralisco extends EdificioUnidadesAvanzadas {

	public GuaridaDeHidralisco() {
		this.vida = 1100;
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
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
