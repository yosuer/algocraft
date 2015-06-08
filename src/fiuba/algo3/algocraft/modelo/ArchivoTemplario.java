package fiuba.algo3.algocraft.modelo;

public class ArchivoTemplario extends EdificioUnidadesAvanzadas {

	public ArchivoTemplario() {
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 200;
		this.tiempoDeConstruccion = 9;	
	}

	@Override
	public Unidad crearUnidad() {
		return new AltoTemplario(this.mapa);
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

}
