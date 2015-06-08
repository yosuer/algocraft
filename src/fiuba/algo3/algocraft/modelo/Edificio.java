package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;


public abstract class Edificio implements IElemento{
	
	protected int vida;
	protected int tiempoDeConstruccion;
	protected Posicion posicion;
	protected int costoMineral;
	protected int costoVespeno;
	protected Mapa mapa;
	protected int nivel = 0;
	protected Collection<IElemento> edificiosRequeridos;
	
	public Edificio(Mapa mapa){
		this.mapa = mapa;
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
	
	public void agregarSobre(IElemento otroElemento) {
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

}
