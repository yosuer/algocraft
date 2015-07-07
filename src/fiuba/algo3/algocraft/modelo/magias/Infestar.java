package fiuba.algo3.algocraft.modelo.magias;

import fiuba.algo3.algocraft.modelo.Activo;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.MagiaUnidad;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.Zerling;


public class Infestar extends MagiaUnidad implements IElementoCreador {

	private Unidad unidadReina;
	
	public Infestar(Unidad unaUnidad)
	{
		this.unidadReina = unaUnidad;
	}
	
	@Override
	public void aplicarA(Unidad unaUnidad) {
		
		unaUnidad.eliminarseDelMapa(this.unidadReina.getMapa());
		this.crearUnidad(unaUnidad);
		this.crearUnidad(unaUnidad);
		
		
	}

	@Override
	public void enviarUnidadAlMapa(Unidad unidad) {
		this.unidadReina.getMapa().agregarElemento(unidad.getPosicion().x(),unidad.getPosicion().y() , unidad);
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		
		Unidad unidadACrear = new Zerling();
				
		unidadACrear.actualizarEstado(new Activo(unidad));
		unidadACrear.setPosicion(unidad.getPosicion());
		this.enviarUnidadAlMapa(unidadACrear);
		
	}

}
