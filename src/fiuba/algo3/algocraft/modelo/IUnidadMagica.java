package fiuba.algo3.algocraft.modelo;

public interface IUnidadMagica {
		
	public void cargarEnergia();
	
	//public void lanzarMagia(Magia magia);
	
	public int energiaActual();
	
	public void perderEnergia();
	
	public void lanzarMagiaAUnidad(Unidad unidad);
	
	public void lanzarMagiaAPosicion(Posicion Posicion);
	
}
