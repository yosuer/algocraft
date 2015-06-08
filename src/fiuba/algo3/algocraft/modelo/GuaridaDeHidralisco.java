package fiuba.algo3.algocraft.modelo;

public class GuaridaDeHidralisco extends EdificioUnidadesAvanzadas {

	public GuaridaDeHidralisco(Mapa mapa) {
		super(mapa);
		this.vida = 1100;
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
	}

	@Override
	public Unidad crearUnidad() {
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
