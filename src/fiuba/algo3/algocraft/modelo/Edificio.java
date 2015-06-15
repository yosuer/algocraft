package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;


public abstract class Edificio implements IElemento,IDaniable{
	
	protected int tiempoDeConstruccion;
	protected Posicion posicion;
	protected int costoMineral;
	protected int costoVespeno;
	protected Mapa mapa;
	protected int nivel;
	protected Collection<IElemento> edificiosRequeridos;
	protected RazaEstado estadoFisico;
	protected IEstado estado; //gestorDeVida
	//protected ICreadorDeElementos creador;
	
	public Edificio(){
		this.nivel = 0;
		this.edificiosRequeridos = new ArrayList<IElemento>();
	}
	
	public int vidaActual(){
		return this.estadoFisico.getVida();
	}
	
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
	
	public void moverseA(Posicion posicion){
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
		mapa.gastarRecursos(costoMineral, costoVespeno);
		this.mapa = mapa;
	}
	
	public void eliminarseDelMapa(Mapa mapa){
		this.mapa.quitarElemento(this);
	}
	
	public void pasarTurno() {
		this.estado.pasarTurno();
	}

	public void daniarse(int danio){
		this.estadoFisico.daniarse(danio);
		if (this.estadoFisico.getVida() <= 0) this.eliminarseDelMapa(mapa);
	}
	
	public void recibirDanioDe(IAtacante a){
		this.daniarse(a.getDanioTierra());
	}
	
	public void actualizarEstado(IEstado estado){
		this.estado = estado;
	}
	
	public void ejecutarAcciones(){
	}
	
	public int getPoblacion(){
		return 0;
	}
}
