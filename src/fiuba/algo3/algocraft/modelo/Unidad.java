package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.excepciones.ErrorNoSePuedeAtacarElementoAereo;
import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;


public abstract class Unidad implements IElemento,IDaniable,IAtacante {

	protected Posicion posicion;
	protected Mapa mapa;
	protected int nivel;
	protected RazaEstado estadoFisico;
	
	protected int transporte;
	protected int vision;
	protected int costoMineral;
	protected int costoVespeno;
	protected int tiempoDeConstruccion;
	protected int danioAire;
	protected int danioTierra;
	protected float suministro;
	protected int rangoAtaqueAire;
	protected int rangoAtaqueTierra;

	public void setPosicion(Posicion posicion){
		this.posicion = posicion;
	}
	
	public Posicion getPosicion(){
		return this.posicion;
	}
	
	public int getNivel() {
		return this.nivel;
	}
	
	public int vidaActual(){
		return this.estadoFisico.getVida();
	}
	
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
	
	public float getSuministro() {
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
		Posicion pos = mapa.getPosicionProxima(this.posicion);
		mapa.ubicarElemento(this, pos);
		this.mapa = mapa;
		this.mapa.consumirPoblacion(this.suministro);
	}
	
	public Posicion buscarPosicionEnMapa(Mapa mapa){
		return mapa.getPosicionProxima(this.posicion);
	}
	
	@Override
	public void pasarTurno() {
		if (this.tiempoDeConstruccion > 0) 
			this.tiempoDeConstruccion--;
	}

	public int getTiempoDeConstruccion() {
		return this.tiempoDeConstruccion;
	}	
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if (o == null) return false;
		if (o.getClass() != this.getClass()) return false; 
			
		Unidad p = (Unidad)o;
		return (p.getPosicion() == this.posicion);
		//return (o.getClass() == this.getClass());
	}
	
	public void atacar(IDaniable elemento) {
		elemento.recibirDanioDe(this);
	}
	
	public void daniarse(int danio){
		this.estadoFisico.daniarse(danio);
		if (this.estadoFisico.getVida() <= 0)this.mapa.quitarElemento(this);
	}
	
	public void recibirDanioDe(IAtacante a) {
		if (this.nivel == 1 & a.getDanioAire() == 0) 
			throw new ErrorNoSePuedeAtacarElementoAereo();
		if (this.nivel == 0) this.daniarse(a.getDanioTierra());
		if (this.nivel == 1) this.daniarse(a.getDanioAire());
	}
	
	public void actualizarEstado(IEstado estado){
		
	}
	
	public void ejecutarAcciones(){
	}
	
	public void eliminarseDelMapa(Mapa mapa){
		this.mapa.desocuparPosicion(this.posicion);
	}

	
}
