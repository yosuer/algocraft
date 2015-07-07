package fiuba.algo3.algocraft.modelo.magias;

import java.util.Iterator;
import java.util.List;

import fiuba.algo3.algocraft.modelo.Inmovilizado;
import fiuba.algo3.algocraft.modelo.MagiaPosicion;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Unidad;


public class Red extends MagiaPosicion {
	
	private Unidad unidadReina;
	
	public Red(Unidad unaUnidad) {
		this.unidadReina = unaUnidad;
	}

	@Override
	public void aplicarA(Posicion pos) {
		List<Unidad> unidadesAAtacar = this.unidadReina.getMapa().getUnidadesProximas(pos, 2);
		Iterator<Unidad> it = unidadesAAtacar.iterator();
		while( it.hasNext())
		{
			Unidad unaUnidad = it.next();
			
			if( unaUnidad.getEquipo() != this.unidadReina.getEquipo())
			{
				unaUnidad.actualizarEstado(new Inmovilizado(unaUnidad));
			}
		}

		
	}

}
