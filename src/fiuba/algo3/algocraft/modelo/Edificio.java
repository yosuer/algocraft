package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;


public abstract class Edificio extends Controlable {
	
	protected ICreadorDeElementos creador;
	
	public Edificio(){
		this.vision = 6; //vision para todos los edificios
	}
	
	public void moverseA(Posicion posicion){
	}
	
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if (o == null) return false;
		
		return (o.getClass() == this.getClass());		
	}
	
	public void agregarseEn(Mapa mapa){
		if ( !mapa.existenElementos(this.elementosRequeridos()) )
				throw new NoExistenLosEdificiosrequeridosParaConstruir();
		if ( mapa.estaOcupado(posicion.x(), posicion.y(), posicion.z()) )
				throw new ErrorPosicionOcupada();
		mapa.gastarRecursos(costoMineral, costoVespeno);
		mapa.agregarControlable(this);
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
