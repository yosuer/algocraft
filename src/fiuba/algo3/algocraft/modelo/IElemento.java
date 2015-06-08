package fiuba.algo3.algocraft.modelo;

import java.util.Collection;


public interface IElemento {
	
	public Posicion getPosicion();
	
	public void setPosicion(Posicion posicion);
	
	//public void agregarSobre(IElemento otroElemento);
	
	public int getNivel();
	
	public boolean moverseA(Posicion posicion);

	public Collection<IElemento> elementosRequeridos();
}
