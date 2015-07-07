package fiuba.algo3.algocraft.modelo;

import java.util.Iterator;
import java.util.List;


public class DaniadoPorRadiacion implements IEstado {

	private Unidad elemento;
	private IArma arma;
	
	public DaniadoPorRadiacion(Unidad unaUnidad)
	{
		this.elemento = unaUnidad;
		this.arma = new ArmaSimple(20,20,10,10);
		this.elemento.recibirDanioDe(arma, 0);
	}
	
	@Override
	public void pasarTurno() {
		this.elemento.recibirDanioDe(arma, 0);
		this.aplicarRadiacionAUnidadesCercanas();
	}
	
	public void aplicarRadiacionAUnidadesCercanas()
	{
		List<Unidad> unidades = this.elemento.getMapa().getUnidadesProximas(this.elemento.getPosicion(), 1);
		Iterator<Unidad> it = unidades.iterator();
		
		while(it.hasNext())
		{
			Unidad unaUnidad = it.next();
			
			//if ( unaUnidad.getEquipo() != this.elemento.getEquipo())
			//{
				unaUnidad.recibirDanioDe(this.arma, 0);
			//}
		
		}
	}	

	@Override
	public void estaActivo() {
		
	}

}
