package fiuba.algo3.algocraft.modelo;


public class Espiral extends EdificioConstructorDeNaves {

	public Espiral(Mapa mapa) {
		super(mapa);
		this.vida = 1200;
		this.costoMineral = 150;
		this.costoVespeno = 150;
		this.tiempoDeConstruccion = 10;
	}

	@Override
	public Unidad crearUnidad() {
		return new Zerling(this.mapa);
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
