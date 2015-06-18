package fiuba.algo3.algocraft.modelo;

public interface ITransporte {

	public void transportar(ITransportable elemento);
	
	public void descargar();
	
	public void descargar(int x, int y);
	
	public int capacidadDisponible();
}
