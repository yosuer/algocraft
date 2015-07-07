package fiuba.algo3.algocraft.modelo;

public interface IMapa {

	public int largo();

	public int ancho();

	public int alto();

	public void nombreEquipo1(String nombre, String razaJ1);

	public void nombreEquipo2(String nombre, String razaJ2);

	public IElemento getElemento(int x, int y, int z);

	public void agregarElemento(int x, int y, IElemento elemento);

	public void quitarElemento(IElemento elemento);

	public void pasarTurnoMapa();

	public Equipo getEquipoActual();

}
