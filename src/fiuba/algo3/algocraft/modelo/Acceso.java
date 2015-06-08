package fiuba.algo3.algocraft.modelo;


public class Acceso extends EdificioUnidadesBasicas {

	
	public Acceso() {
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 8;
	}

	@Override
	public Unidad crearUnidad() {
		return new Zealot();
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
