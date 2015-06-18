package fiuba.algo3.algocraft.modelo;

public interface ITransportable {

	public void transportardoPor(ITransporte elemento);
	
	public void descargarseEn(int x, int y);

	public int getOcupacion();
}
