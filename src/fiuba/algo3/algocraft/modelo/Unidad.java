package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;


public abstract class Unidad implements IElemento {

	protected Posicion posicion;
	protected Mapa mapa;
	protected int nivel = 0;
	
	protected int transporte;
	protected int vision;
	protected int costoMineral;
	protected int costoVespeno;
	protected int tiempoDeConstruccion;
	protected int danioAire;
	protected int danioTierra;
	protected int suministro;
	protected int rangoAtaqueAire;
	protected int rangoAtaqueTierra;
	protected int vida;

	
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
	
	public int getTransporte() {
		return this.transporte;
	}
	
	public int getVision() {
		return this.vision;
	}
	
	public int getDanioAire() {
		return this.danioAire;
	}
	
	public int getDanioTierra() {
		return this.danioTierra;
	}
	
	public int getSuministro() {
		return this.suministro;
	}
	
	public int getRangoAtaqueAire() {
		return this.rangoAtaqueAire;
	}
	
	public int getRangoAtaqueTierra() {
		return this.rangoAtaqueTierra;
	}
	
	public void moverseA(Posicion pos){
		if (mapa.estaOcupado(pos.x(), pos.y(), pos.z())) throw new ErrorPosicionOcupada();
		this.posicion = pos;
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

	public int getTiempoDeConstruccion() {
		return this.tiempoDeConstruccion;
	}

}
