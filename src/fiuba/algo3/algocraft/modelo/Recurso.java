package fiuba.algo3.algocraft.modelo;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.algocraft.excepciones.ErrorAgregandoElementoAlMapa;
import fiuba.algo3.algocraft.excepciones.NoExistenLosEdificiosrequeridosParaConstruir;
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

	public abstract void asignarExtractor(ExtractorDeRecursos extractor);

	public abstract ExtractorDeRecursos getExtractor();
	
	public boolean moverseA(Posicion posicion){
		return false;
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

}
