package fiuba.algo3.algocraft.modelo;

public class ArmaSimple implements IArma {

	private int[] danios;
	private int[] alcances;

	public ArmaSimple(int danioTierra, int danioAire, 
						int alcanceTierra, int alcanceAire) {
		this.danios = new int[2];
		this.alcances = new int[2];
		this.danios[0] = danioTierra;
		this.danios[1] = danioAire;
		this.alcances[0] = alcanceTierra;
		this.alcances[1] = alcanceAire;
	}

	@Override
	public int getDanio(int nivel) {
		return danios[nivel];
	}
	
	@Override
	public int getAlcance(int nivel) {
		return alcances[nivel];
	}

	@Override
	public void atacar(IDaniable daniable, int distancia) {
		daniable.recibirDanioDe(this,distancia);
	}

}
