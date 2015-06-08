package fiuba.algo3.algocraft.modelo;

public class Fabrica extends EdificioUnidadesAvanzadas {

	public Fabrica(Mapa mapa) {
		super(mapa);
		this.vida = 1250;
		this.costoMineral = 200;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 12;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

	@Override
	public Unidad crearUnidad() {
		return new Golliat(this.mapa);
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

}
