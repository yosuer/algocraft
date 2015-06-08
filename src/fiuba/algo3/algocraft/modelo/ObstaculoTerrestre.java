package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;


public class ObstaculoTerrestre implements IElemento {
	
	Posicion pos;
	int nivel;
	
	public ObstaculoTerrestre() {
	}

	@Override
	public Posicion getPosicion() {
		return pos;
	}

	@Override
	public void setPosicion(Posicion posicion) {
		this.pos = posicion;
	}

	@Override
	public int getNivel() {
		return nivel;
	}

	@Override
	public boolean moverseA(Posicion posicion) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Collection<IElemento> elementosRequeridos(){
		return new ArrayList<IElemento>();
	}

	@Override
	public void agregarseEn(Mapa mapa) {
		// TODO Auto-generated method stub
		
	}

}
