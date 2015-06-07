package fiuba.algo3.algocraft.modelo;


public abstract class Edificio implements IElemento{
	
	protected int vida;
	protected int tiempoDeConstruccion;
	protected Posicion posicion;
	protected int costoMineral;
	protected int costoVespeno;
	protected Mapa mapa;
	protected int nivel = 0;
	
	public Edificio(Mapa mapa){
		this.mapa = mapa;
		this.nivel = 0;
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
	
	public boolean moverseA(Posicion posicion){
		return false;
	}

}
