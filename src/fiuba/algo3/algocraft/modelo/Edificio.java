package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.excepciones.ErrorExtractorDeRecursosIncompatible;
import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;


public abstract class Edificio implements IElemento{
	
	protected int vida;
	protected int tiempoDeConstruccion;
	protected Posicion posicion;
	protected int costoMineral;
	protected int costoVespeno;
	protected Mapa mapa;
	protected int nivel = 0;
	protected Collection<IElemento> edificiosRequeridos;
	
	public Edificio(){
		this.nivel = 0;
		this.edificiosRequeridos = new ArrayList<IElemento>();
	}
	
	public abstract int vidaActual();

	public void setPosicion(Posicion posicion){
		this.posicion = posicion;
	}
	
	public Posicion getPosicion(){
		return this.posicion;
	}
	
	public int getNivel() {
		return this.nivel;
	}
	
	public int getCostoMineral() {
		return this.costoMineral;
	}
	
	public int getCostoVespeno() {
		return this.costoVespeno;
	}
	
	public boolean moverseA(Posicion posicion){
		return false;
	}
	
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if (o == null) return false;
		
		return (o.getClass() == this.getClass());		
	}
	
	public Collection<IElemento> elementosRequeridos(){
		return this.edificiosRequeridos;
	}
	
	public void agregarseEn(Mapa mapa){
		if ( !mapa.existenElementos(this.elementosRequeridos()) )
				throw new NoExistenLosEdificiosrequeridosParaConstruir();
		if ( mapa.estaOcupado(posicion.x(), posicion.y(), posicion.z()) )
				throw new ErrorPosicionOcupada();
		this.mapa = mapa;
	}

}
