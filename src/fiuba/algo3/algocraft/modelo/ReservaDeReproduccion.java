package fiuba.algo3.algocraft.modelo;

public class ReservaDeReproduccion extends EdificioUnidadesBasicas {

	public ReservaDeReproduccion(Mapa mapa) {
		super(mapa);
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 12;	}

	@Override
	public Unidad crearUnidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {
		// TODO Auto-generated method stub

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
