package fiuba.algo3.algocraft.modelo;

public interface ITransportador {

	public void transportar(ITransportable elemento);

	public void descargar(int x, int y);

	public int capacidadDisponible();

	public void expulsarUnTransportable(int x, int y);
}
