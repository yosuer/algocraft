package fiuba.algo3.algocraft.modelo;


public class PuertoEstelarTerran extends EdificioConstructorDeNaves {

	public PuertoEstelarTerran(Mapa mapa) {
		super(mapa);
		this.vida = 1300;
		this.costoMineral = 150;
		this.costoVespeno = 100;
		this.tiempoDeConstruccion = 10;
	}

	@Override
	public Unidad crearUnidad() {
		return new Marine(this.mapa);
	}

	@Override
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public void agregarSobre(IElemento otroElemento) {
		
	}

	@Override
	public int vidaActual() {
		return this.vida;
	}

}
