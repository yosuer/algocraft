package fiuba.algo3.algocraft.modelo.magias;


import java.util.Iterator;
import java.util.List;

import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.IUnidadMagica;
import fiuba.algo3.algocraft.modelo.MagiaPosicion;
import fiuba.algo3.algocraft.modelo.Posicion;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.Activo;


public class EMP extends MagiaPosicion {
	
	private Unidad unidadNaveCienca;
	
	public EMP(Unidad unidad) {
		this.unidadNaveCienca = unidad;
	}

	@Override
	public void aplicarA(Posicion pos) {
		List<Unidad> unidadesAAtacar = this.unidadNaveCienca.getMapa().getUnidadesProximas(pos, 2);
		Iterator<Unidad> it = unidadesAAtacar.iterator();
		
		while(it.hasNext())
		{
			Unidad unidad = it.next();
			
			//if ( it.next().getEquipo() != this.unidad.getEquipo())
			{
				try{
				((ElementoProtoss)unidad).vaciarEscudo();
				((IUnidadMagica)unidad).perderEnergia();
				} catch (ClassCastException e) {}
			}
		}
		
	}
}
