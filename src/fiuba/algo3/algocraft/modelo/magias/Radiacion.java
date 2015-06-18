package fiuba.algo3.algocraft.modelo.magias;

import fiuba.algo3.algocraft.modelo.DaniadoPorRadiacion;
import fiuba.algo3.algocraft.modelo.Magia;
import fiuba.algo3.algocraft.modelo.Unidad;

public class Radiacion extends Magia {

	@Override
	public void aplicar(Unidad unaUnidad) {
		unaUnidad.actualizarEstado(new DaniadoPorRadiacion(unaUnidad));
		
	}
	


}
