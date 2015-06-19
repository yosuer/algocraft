package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public abstract class Estatico implements IElemento, ObjetoPosicionable, ObjetoVivo{
	
	protected Mapa mapa;
	protected Posicion posicion;
	protected int nivel = 0;
	
	public Estatico(){
		this.nivel = 0;
	}
	
	@Override
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	@Override
	public int getNivel() {
		return this.nivel;
	}
	
	@Override
	public void agregarseEn(Mapa mapa){
		if ( mapa.estaOcupado(posicion.x(), posicion.y(), posicion.z()) )
				throw new ErrorPosicionOcupada();
		mapa.agregarEstatico(this);
		this.mapa = mapa;
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
	
	
}
