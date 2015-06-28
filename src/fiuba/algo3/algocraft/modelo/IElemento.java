package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public abstract class IElemento  implements ObjetoPosicionable, ObjetoVivo{

	protected Mapa mapa;
	protected Posicion posicion;
	protected String nombre = "";
	protected int nivel;
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
		posicion.setElemento(this);
	}
	
	public Posicion getPosicion(){
		return this.posicion;
	}
	
	@Override
	public int getX() {
		return this.posicion.x();
	}

	@Override
	public int getY() {
		return this.posicion.y();
	}

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
	}	
	
	public abstract void agregarseEn(Mapa mapa);
	
	public int getNivel(){
		return this.nivel;
	}
	
	public abstract void eliminarseDelMapa(Mapa mapa);
	
	public String nombre(){
		return this.nombre;
	}
	
}
