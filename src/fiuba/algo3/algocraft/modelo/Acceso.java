package fiuba.algo3.algocraft.modelo;


public class Acceso extends EdificioUnidadesBasicas {

	
	public Acceso(Mapa mapa) {
		super(mapa);
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
		return 0;
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
