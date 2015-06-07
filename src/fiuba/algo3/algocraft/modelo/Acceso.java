package fiuba.algo3.algocraft.modelo;


public class Acceso extends EdificioUnidadesBasicas {

	
	public Acceso(Mapa mapa) {
		super(mapa);
		this.vida = 900;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 6;
	}

	@Override
	public Unidad crearUnidad() {
		return new Zealot(this.mapa);
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
