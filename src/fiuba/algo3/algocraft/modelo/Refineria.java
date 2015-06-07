package fiuba.algo3.algocraft.modelo;


public class Refineria extends ExtractorDeGasVespeno {

	public Refineria(Mapa mapa) {
		super(mapa);
		this.vida = 750;
		this.costoMineral = 100;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 6;
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
