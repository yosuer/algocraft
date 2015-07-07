package fiuba.algo3.algocraft.modelo.magias;

import java.util.Iterator;
import java.util.List;

import fiuba.algo3.algocraft.modelo.ArmaSimple;
import fiuba.algo3.algocraft.modelo.IArma;
import fiuba.algo3.algocraft.modelo.MagiaPosicion;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Unidad;


public class TormentaPsionica extends MagiaPosicion {
	
	private Posicion posicion;
	private IArma arma;
	private Unidad unidadAltoTemplario;

	
	public TormentaPsionica(Unidad unidad) {
		this.arma =new ArmaSimple(100,100,10,10);
		this.unidadAltoTemplario =unidad;
	}

	@Override
	public void aplicarA(Posicion pos) {
		List<Unidad> unidades = unidadAltoTemplario.getMapa().getUnidadesProximas(pos, 2);
		Iterator<Unidad> it = unidades.iterator();
		
		while(it.hasNext())
		{
			Unidad unidad = it.next();
			unidad.recibirDanioDe(this.arma, 0);
		}
	}
	
}
