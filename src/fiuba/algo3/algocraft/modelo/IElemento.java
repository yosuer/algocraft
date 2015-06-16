package fiuba.algo3.algocraft.modelo;

public interface IElemento {

	public Posicion getPosicion();
	
	public void setPosicion(Posicion posicion);
	
	public void agregarseEn(Mapa mapa);
	
	public int getNivel();
	
	public void eliminarseDelMapa(Mapa mapa); 
	
}
