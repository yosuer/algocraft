package fiuba.algo3.algocraft.modelo;


public class ZergMineral extends ExtractorDeMineral {

	public ZergMineral(Mapa mapa) {
		super(mapa);
		this.recolectado = 0;
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
		// TODO Auto-generated method stub
		return 0;
	}

}
