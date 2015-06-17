package fiuba.algo3.algocraft.modelo;

import java.util.List;
import fiuba.algo3.algocraft.excepciones.ErrorObjetivoFueraDelAlcance;
import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;


public abstract class Edificio extends Controlable {
	
	public Edificio(){
		this.vision = 6; //vision para todos los edificios
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

	public void recibirDanioDe(IArma arma, int distancia){
		if (distancia > arma.getAlcance(nivel)) throw new ErrorObjetivoFueraDelAlcance();
		this.estadoFisico.daniarse(arma.getDanio(nivel));
		if (this.estadoFisico.getVida() <= 0) this.eliminarseDelMapa(mapa);
	}
	
	public void actualizarEstado(IEstado estado){
		this.estado = estado;
	}
	
	public void ejecutarAcciones(){
		this.estadoFisico.regenerarse();
	}
	
	public int getPoblacion(){
		return 0;
	}
	
	public List<Posicion> mover(int x, int y){
		return null;
	}

}
