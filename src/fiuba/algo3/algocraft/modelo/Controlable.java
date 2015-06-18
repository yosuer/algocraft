package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Controlable implements IDaniable, IElemento{

	protected Collection<Controlable> edificiosRequeridos;
	protected Posicion posicion;
	protected int costoMineral;
	protected int costoVespeno;
	protected Mapa mapa;
	protected int nivel;
	protected IRazaEstado estadoFisico;
	protected IEstado estado; //gestorDeVida
	protected int vision;
	protected Equipo equipo;
	
	public Controlable(){
		this.nivel = 0;
		this.edificiosRequeridos = new ArrayList<Controlable>();
	}
	
	public int getX(){
		return this.posicion.x();
	}
	
	public int getY(){
		return this.posicion.y();
	}
	
	public void estaActivo() {
		this.estado.estaActivo();
	}
	
	public void setEquipo(Equipo equipo){
		this.equipo = equipo;
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
	
	public abstract List<Posicion> mover(int x, int y);
	
	public abstract void agregarseEn(Mapa mapa);

}
