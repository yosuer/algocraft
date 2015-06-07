package fiuba.algo3.algocraft.modelo;


public class Asimilador extends ExtractorDeGasVespeno {

	public Asimilador(Mapa mapa) {
		super(mapa);
		this.vida = 1000;
		this.costoMineral = 150;
		this.costoVespeno = 0;
		this.tiempoDeConstruccion = 12;
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
