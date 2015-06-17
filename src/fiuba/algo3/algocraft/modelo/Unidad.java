package fiuba.algo3.algocraft.modelo;

import java.util.Queue;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorNoSePuedeAtacarElemento;
import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;

public abstract class Unidad extends Controlable 
									implements IAtacante {

	protected Queue<Unidad> movimientos; //guardar movimientos
	
	protected float suministro;
	protected int transporte;
	protected IArma arma;

	public int vidaActual(){
		return this.estadoFisico.getVida();
	}
	
	public int getTransporte() {
		return this.transporte;
	}
	
	public float getSuministro() {
		return this.suministro;
	}
	
	public void moverseA(Posicion pos){
		if (mapa.estaOcupado(pos.x(), pos.y(), pos.z())) throw new ErrorPosicionOcupada();
		this.posicion = pos;
	}
	
	public void agregarseEn(Mapa mapa){
		Posicion pos = mapa.getPosicionProxima(this.posicion);
		mapa.agregarControlable(this);
		mapa.ubicarElemento(this, pos);
		this.mapa = mapa;
	}
	
	public Posicion buscarPosicionEnMapa(Mapa mapa){
		return mapa.getPosicionProxima(this.posicion);
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
		Posicion posObjetivo = ((Controlable)elemento).getPosicion();
		int distancia = this.mapa.getDistancia(this.posicion, posObjetivo);
		
		this.arma.atacar(elemento,distancia);
	}
	
	public void recibirDanioDe(IArma arma, int distancia) {
		if (distancia > arma.getAlcance(nivel)) throw new ErrorObjetivoFueraDelAlcance();
		this.estadoFisico.daniarse(arma.getDanio(nivel));
		if (this.estadoFisico.getVida() <= 0)this.mapa.quitarElemento(this);
	}
	
	public void ejecutarAcciones(){
		this.estadoFisico.regenerarse();
	}
	
	public void eliminarseDelMapa(Mapa mapa){
		this.mapa.desocuparPosicion(this.posicion);
	}
	
	public boolean listaParaSalir(){
		try {
			this.estado.estaActivo();
		} catch (ErrorEdificioEnConstruccion e){
			return false;
		} catch (Exception e){
			
		}
		return true;
	}
	
}
