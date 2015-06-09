package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;


public abstract class Unidad implements IElemento {

	protected int vida;
	protected int tiempoDeConstruccion;
	protected Posicion posicion;
	protected int costoMineral;
	protected int costoVespeno;
	protected Mapa mapa;
	protected int nivel = 0;
	
	public Unidad(){
	}
	
	public void setPosicion(Posicion posicion){
		this.posicion = posicion;
	}
	
	public Posicion getPosicion(){
		return this.posicion;
	}
	
	public abstract int vidaActual();
	
	public int getCostoMineral() {
		return this.costoMineral;
	}
	
	public int getCostoVespeno() {
		return this.costoVespeno;
	}
	
	public boolean moverseA(Posicion nuevaPos){
		
		if (!mapa.estaOcupado(nuevaPos.x(), nuevaPos.y(), nuevaPos.z())){
			mapa.agregarElemento(nuevaPos.x(), nuevaPos.y(), this);
			return true;
		}
		
		return false;
	}
	
	public Collection<IElemento> elementosRequeridos(){
		return new ArrayList<IElemento>();
	}
	
	public void agregarseEn(Mapa mapa){
		if ( mapa.estaOcupado(posicion.x(), posicion.y(), posicion.z()) )
				throw new ErrorPosicionOcupada();
		this.mapa = mapa;
	}
	
	@Override
	public void pasarTurno() {
		if (this.tiempoDeConstruccion > 0) 
			this.tiempoDeConstruccion--;
	}

}
