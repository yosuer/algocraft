package fiuba.algo3.algocraft.modelo;

public class ArmaSimple implements Arma {

	private int danioTierra;
	private int danioAire;
	private int alcanceTierra;
	private int alcanceAire;

	public ArmaSimple(int danioTierra, int danioAire, 
						int alcanceTierra, int alcanceAire) {
		this.danioTierra = danioTierra;
		this.danioAire = danioAire;
		this.alcanceTierra = alcanceTierra;
		this.alcanceAire = alcanceAire;
	}

	@Override
	public int getDanioTierra() {
		return this.danioTierra;
	}

	@Override
	public int getDanioAire() {
		return this.danioAire;
	}

	@Override
	public int getAlcanceTierra() {
		return this.alcanceTierra;
	}

	@Override
	public int getAlcanceAire() {
		return this.alcanceAire;
	}

}
