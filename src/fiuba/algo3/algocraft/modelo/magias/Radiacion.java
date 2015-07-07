package fiuba.algo3.algocraft.modelo.magias;

import fiuba.algo3.algocraft.modelo.DaniadoPorRadiacion;
import fiuba.algo3.algocraft.modelo.MagiaUnidad;
import fiuba.algo3.algocraft.modelo.Unidad;


public class Radiacion extends MagiaUnidad {

	@Override
	public void aplicarA(Unidad unaUnidad) {
		unaUnidad.actualizarEstado(new DaniadoPorRadiacion(unaUnidad));
	}
	


}
