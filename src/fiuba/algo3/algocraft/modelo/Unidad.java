package fiuba.algo3.algocraft.modelo;


public abstract class Unidad implements IElemento {

	protected int vida;
	protected int tiempoDeConstruccion;
	protected Posicion posicion;
	protected int costoMineral;
	protected int costoVespeno;
	protected Mapa mapa;
	protected int nivel = 0;
	
	public Unidad(Mapa mapa) {
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
	
	public boolean moverseA(Posicion nuevaPos){
		
		if (!mapa.estaOcupado(nuevaPos.x(), nuevaPos.y(), nuevaPos.z())){
			mapa.agregarElemento(nuevaPos.x(), nuevaPos.y(), this);
			return true;
		}
		
		return false;
	}
	
	
}
