package fiuba.algo3.algocraft.modelo;

public interface IMapa {
	
	public int largo();
	public int ancho();
	public int alto();
	
	public void agregarEquipo(Equipo equipo);
	
	public IElemento getElemento(int x, int y, int z);
	
	public void agregarElemento(int x, int y, IElemento elemento);
	
	public void quitarElemento(IElemento elemento);
	
	public void pasarTurnoMapa();
	
}
