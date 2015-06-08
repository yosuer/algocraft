package fiuba.algo3.algocraft.modelo;

public class Fabrica extends EdificioUnidadesAvanzadas {

	public Fabrica() {
		this.vida = 1250;
		this.costoMineral = 200;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 12;
		this.edificiosRequeridos.add(new Barraca());
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public Unidad crearUnidad() {
		return new Golliat();
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

}
