package fiuba.algo3.algocraft.modelo;

import java.util.Collection;


public interface IElemento {

	public Posicion getPosicion();
	
	public void setPosicion(Posicion posicion);
	
	public void agregarseEn(Mapa mapa);
	
	public int getNivel();
	
	public void moverseA(Posicion posicion);

	public Collection<IElemento> elementosRequeridos();
	
	public void actualizarEstado(IEstado nuevoEstado);
	
	public void pasarTurno();
	
	public void ejecutarAcciones();
	
	public int getPoblacion();
}
