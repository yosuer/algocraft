package fiuba.algo3.algocraft.modelo;

public class Pilon extends EdificioCasa {

	public Pilon(Mapa mapa) {
		super(mapa);
		this.vida = 600;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 5;
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
