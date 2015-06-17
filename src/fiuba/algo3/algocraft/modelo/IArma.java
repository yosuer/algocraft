package fiuba.algo3.algocraft.modelo;

public interface IArma {

	public int getDanio(int nivel);
	
	public int getAlcance(int nivel);
	
	public void atacar(IDaniable daniable, int distancia);

}
