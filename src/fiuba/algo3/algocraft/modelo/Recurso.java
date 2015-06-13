package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.excepciones.ErrorPosicionOcupada;


public abstract class Recurso implements IElemento{
	
	protected Mapa mapa;
	protected int reserva;
	protected Posicion posicion;
	protected int nivel = 0;
	
	public Recurso(){
	}
	
	public abstract int reservaDisponible();

	public abstract int extraer();

	public abstract void asignarExtractor(IExtractorDeRecursos extractor);

	public abstract IExtractorDeRecursos getExtractor();
	
	public void moverseA(Posicion posicion){
	}
	
	public Collection<IElemento> elementosRequeridos(){
		return new ArrayList<IElemento>();
	}
	
	public void agregarseEn(Mapa mapa){
		if ( mapa.estaOcupado(posicion.x(), posicion.y(), posicion.z()) )
				throw new ErrorPosicionOcupada();
		this.mapa = mapa;
	}
	
	@Override
	public void pasarTurno() {
	}
	
	public void actualizarEstado(IEstado estado){
		
	}
	
	public void ejecutarAcciones(){
	}
	
	public int getPoblacion(){
		return 0;
	}

}
