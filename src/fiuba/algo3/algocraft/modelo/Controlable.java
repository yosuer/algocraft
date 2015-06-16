package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Controlable implements IDaniable, IElemento{

	protected Collection<Controlable> edificiosRequeridos;
	protected int tiempoDeConstruccion;
	protected Posicion posicion;
	protected int costoMineral;
	protected int costoVespeno;
	protected Mapa mapa;
	protected int nivel;
	protected RazaEstado estadoFisico;
	protected IEstado estado; //gestorDeVida
	protected int vision;
	
	public Controlable(){
		this.nivel = 0;
		this.edificiosRequeridos = new ArrayList<Controlable>();
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
	
	public int getVision() {
		return this.vision;
	}
	
	public Collection<Controlable> elementosRequeridos(){
		return this.edificiosRequeridos;
	}
	
	public int getTiempoDeConstruccion() {
		return this.tiempoDeConstruccion;
	}
	
	public void actualizarEstado(IEstado estado){
		this.estado = estado;
	}

	public void pasarTurno() {
		this.estado.pasarTurno();
	}
	
	public int vidaActual(){
		return this.estadoFisico.getVida();
	}
	
	public abstract void ejecutarAcciones();
	
	public abstract void moverseA(Posicion posicion);
	
	public abstract void agregarseEn(Mapa mapa);


}
