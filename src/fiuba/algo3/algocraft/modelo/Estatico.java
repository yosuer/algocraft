package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;

public abstract class Estatico implements IElemento{
	
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

}
